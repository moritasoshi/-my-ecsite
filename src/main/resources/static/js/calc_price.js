$(function() {
// 合計金額の表示を行う
	// 初期値設定
    calcPrice();

    // 削除ボタン押下時
	$('button#btn_delete').change(calcPrice());

// 合計金額と消費税の計算を行うcalcPriceメソッド
	function calcPrice(){
		var total = 0;
    	const taxRate = 0.1;
    	var subTotalElem = $('span.subTotal').each(function(){
    	    total += Number($(this).text().replace(/,/, ''));
    	});
    	var tax = total * taxRate;
    	total += tax;
        // 金額の更新
        $('#tax').text(tax.toLocaleString());
        $('#total-price').text(total.toLocaleString());
	};
});
