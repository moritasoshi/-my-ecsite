package com.example.myecsite.controller;

import com.example.myecsite.domain.Item;
import com.example.myecsite.domain.User;
import com.example.myecsite.form.RegisterUserForm;
import com.example.myecsite.service.ItemService;
import com.example.myecsite.service.RegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping("/")
public class MyecsiteController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private ItemService itemService;

    @ModelAttribute
    public RegisterUserForm setUpRegisterUserForm() {
        return new RegisterUserForm();
    }

    /////////////////////////
    //// 商品一覧画面
    /////////////////////////
    @RequestMapping("")
    public String init(Model model) {
        List<Item> itemList = itemService.showAllItems();
        model.addAttribute("itemList", itemList);
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
