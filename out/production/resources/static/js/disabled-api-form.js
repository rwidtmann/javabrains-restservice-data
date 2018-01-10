(function ($) {
    $.fn.disabledApiForm = function (options) {
        return this.each(function () {
            var $this = $(this);

            var $state = $this.find('.state');
            var $account = $this.find('.account');
            var $product = $this.find('.product');
            var $api = $this.find('.api');
            var $submitButtons = $this.find('.submit-buttons');

            var $disabledApiTypes = $this.find('input[name="disabledApiType"]');
            $disabledApiTypes.change(function (e) {
                $state.show();
                if (e.target.value === 'ACCOUNT') {
                    $account.show();
                    $product.hide();
                } else {
                    $product.show();
                    $account.hide();
                }
                $api.show();
                $submitButtons.show();
            });

            if (options) {
                $disabledApiTypes
                    .filter('[value=' + options.disabledApiType + ']')
                    .prop('checked', true)
                    .change();
            }
        });
    }
})(jQuery);