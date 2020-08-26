$(function() {
//	// 0. security認証
//	var token = $("meta[name='_csrf']").attr('content');
//	var header = $("meta[name='_csrf_header']").attr('content');
//	$(document).ajaxSend(function(e, xhr, options) {
//		xhr.setRequestHeader(header, token);
//	});

	// 1. 住所検索
	$('#searchAddress').on('click', function() {
		searchAddress();
	});

	/**
	 * 郵便番号で住所検索を行う
	 */
	function searchAddress() {
        $.ajax({
            type: 'GET',
            url: 'https://apis.postcode-jp.com/api/v3/postcodes',
            data: {
                postcode: $('#zipcode').val().replace('-','')
            },
            dataType: 'json',
        })
            .done(function(result) {
                var allAddress = result.data[0].allAddress;
                $('#address').val(allAddress);
            })
            .fail(function(XMLHttpRequest, textStatus, errorThrown) {
                alert('リクエストに失敗' + textStatus + ':\n' + errorThrown);
            });
    }
});