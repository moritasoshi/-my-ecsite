package com.example.myecsite.controller;

import com.example.myecsite.domain.*;
import com.example.myecsite.enums.SortEnum;
import com.example.myecsite.form.ItemForm;
import com.example.myecsite.form.OrderForm;
import com.example.myecsite.form.RegisterUserForm;
import com.example.myecsite.form.SearchItemForm;
import com.example.myecsite.service.CartService;
import com.example.myecsite.service.ItemService;
import com.example.myecsite.service.RegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;

@Controller
@RequestMapping("")
public class MyecsiteController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private HttpSession session;
    @Autowired
    private CartService cartService;

    @ModelAttribute
    public RegisterUserForm setUpRegisterUserForm() {
        return new RegisterUserForm();
    }

    @ModelAttribute
    public SearchItemForm setUpSearchItemForm() {
        return new SearchItemForm();
    }

    @ModelAttribute
    public ItemForm setUpItemForm() {
        return new ItemForm();
    }

    @ModelAttribute
    public OrderForm setUpOrderForm() {
        return new OrderForm();
    }


    /////////////////////////
    //// 商品一覧画面
    /////////////////////////
    @RequestMapping("")
    public String index(Model model, SearchItemForm form) {
        // 不正な値のチェック
        Integer page = form.getPage();
        Integer totalPage = (Integer) session.getAttribute("totalPage");
        if (isNull(page) || page <= 0 || isNull(totalPage)) {
            page = 1;
        } else if (page > totalPage) {
            page = totalPage;
        }

        // 検索条件
        SearchItem searchItem = new SearchItem();
        searchItem.setName(form.getName());
        searchItem.setPage(page);
        searchItem.setSortEnum(SortEnum.getById(form.getSortId()));
        ItemPage itemPage = itemService.searchItems(searchItem);

        model.addAttribute("searchItemForm", form);
        model.addAttribute("itemList", itemPage.getItemList());
        session.setAttribute("totalPage", itemPage.getTotalPage()); // サーバー用

        return "item_list_curry";
    }

    /////////////////////////
    //// 商品詳細画面
    /////////////////////////
    @RequestMapping("/showDetails")
    public String showDetails(Integer id, Model model) {
        Item item = itemService.showDetails(id);
        model.addAttribute("item", item);
        return "item_detail";
    }

    /////////////////////////
    //// ショッピングカート
    /////////////////////////
    @RequestMapping("/addToCart")
    public String addToCart(@AuthenticationPrincipal LoginUser loginUser, ItemForm form, Model model) {
        if (Objects.isNull(loginUser)) {
            return "redirect:/toLogin";
        }
        // カートへの追加操作
        Integer userId = loginUser.getUser().getId();
        OrderItem orderItem = new OrderItem();
        BeanUtils.copyProperties(form, orderItem);
        List<Integer> toppingIdList = form.getToppingIdList();
        cartService.addToCart(userId, orderItem, toppingIdList);

        // 追加が完了すればカート一覧画面へ遷移
        return "redirect:/shoppingCart";
    }

    @RequestMapping("/shoppingCart")
    public String shoppingCart(@AuthenticationPrincipal LoginUser loginUser, Model model) {
        Order cart = cartService.showCart(loginUser.getUser().getId());
        model.addAttribute("orderItemList", cart.getOrderItemList());
        return "cart_list";
    }

    @RequestMapping("/deleteFromCart")
    public String deleteFromCart(Integer orderItemId) {
        cartService.deleteOrderItemFromCart(orderItemId);
        return "redirect:/shoppingCart";
    }

    /////////////////////////
    //// 商品の購入
    /////////////////////////

    @RequestMapping("/orderConfirm")
    public String orderConfirm(@AuthenticationPrincipal LoginUser loginUser, Model model) {
        Order cart = cartService.showCart(loginUser.getUser().getId());
        model.addAttribute("orderItemList", cart.getOrderItemList());
        return "order_confirm";
    }

    @RequestMapping("/order")
    public String order(@Validated OrderForm orderForm, BindingResult result) {
        if (result.hasErrors()) {
            return "order_confirm";
        }
        return "order_finished";
    }


    /////////////////////////
    //// ログイン
    /////////////////////////
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /////////////////////////
    //// ユーザー登録
    /////////////////////////
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register_user";
    }

    @RequestMapping("/register")
    public String register(@Validated RegisterUserForm form, BindingResult result, Model model) {
        //// バリデーションチェック
        FieldError fieldError;
        // emailが既に登録済みの場合
        if (registerService.isRegistered(form.getEmail())) {
            fieldError = new FieldError(result.getObjectName(), "email", "そのメールアドレスはすでに使われています");
            result.addError(fieldError);
        }
        // パスワード不一致の場合
        if (!form.getPassword().equals(form.getVerificationPassword())) {
            fieldError = new FieldError(result.getObjectName(), "verificationPassword", "パスワードと確認用パスワードが不一致です");
            result.addError(fieldError);
        }
        if (result.hasErrors()) {
            return toRegister();
        }

        // DBへの登録
        User user = new User();
        BeanUtils.copyProperties(form, user);
        registerService.registerUser(user);

        return "redirect:/toLogin";
    }
}
