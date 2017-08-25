(function ($) {
    $.fn.stateFilter = function (options) {
        return this.each(function () {
            var $this = $(this);

            var $state = $this.find("#state");
            var $productType = $this.find("#productType");
            $state.change(function (e) {
                $productType.empty();
                $productType.append($('<option>'));
                $productType.append($.map(options.states[e.target.value], function (value) {
                    return $("<option>", {
                        value: value,
                        text: value
                    });
                }));
            });

            $state
                .val(options.selectedState)
                .change();
            $productType
                .val(options.selectedProductType)
                .change();
            return this;
        });
    }
})(jQuery);