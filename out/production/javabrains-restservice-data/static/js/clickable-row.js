(function ($) {
    $.fn.clickableRow = function () {
        return this.each(function () {
            var $this = $(this);

            $this.click(function() {
                window.location = $this.attr('href');
            });

            return this;
        });
    }
})(jQuery);