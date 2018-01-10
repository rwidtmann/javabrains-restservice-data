(function ($) {
    $.fn.benefitOverrideForm = function (options) {
        return this.each(function () {
            var $this = $(this);

            var $benefitOverrideTypes = $this.find('.benefit-override-types');
            var $benefitOverrideTypeValue = $benefitOverrideTypes.find('.benefit-override-type-VALUE');
            var $benefitOverrideTypeRadios = $benefitOverrideTypes.find('input[type="radio"]');

            var $benefit = $this.find('.benefit');
            var $tier = $this.find('.tier');
            var $tierLevel = $this.find('.tier-level');
            var $customName = $this.find('.custom-name');
            var $notes = $this.find('.notes');
            var $submitButtons = $this.find('.submit-buttons');

            var $benefitOverrideActions = $this.find('input[name="benefitOverrideAction"]');
            $benefitOverrideActions.change(function (e) {
                $benefitOverrideTypes.show();

                if (e.target.value === 'HIDE') {
                    $benefitOverrideTypeValue.hide();
                } else if (e.target.value === 'CUSTOMIZE') {
                    $benefitOverrideTypeValue.show();
                }
                $benefitOverrideTypeRadios.prop('checked', false);

                $benefit.hide();
                $tier.hide();
                $tierLevel.hide();
                $customName.hide();
                $notes.hide();
                $submitButtons.hide();
            });

            var $benefitOverrideType = $this.find('input[name="benefitOverrideType"]');
            $benefitOverrideType.change(function (e) {
                switch (e.target.value) {
                    case 'BENEFIT':
                        $benefit.show();
                        $tier.hide();
                        $tierLevel.hide();
                        break;
                    case 'TIER':
                        $benefit.hide();
                        $tier.show();
                        $tierLevel.show();
                        break;
                    case 'VALUE':
                        $benefit.show();
                        $tier.show();
                        $tierLevel.show();
                        $tierLevel.show();
                        break;
                }
                if ($benefitOverrideActions.filter(':checked').val() === 'CUSTOMIZE') {
                    $customName.show();
                }
                $notes.show();
                $submitButtons.show();
            });

            if (options) {
                if (options.benefitOverrideAction) {
                    $benefitOverrideActions
                        .filter('[value=' + options.benefitOverrideAction + ']')
                        .prop('checked', true)
                        .change();
                }
                if (options.benefitOverrideType) {
                    $benefitOverrideTypeRadios
                        .filter('[value=' + options.benefitOverrideType + ']')
                        .prop('checked', true)
                        .change();
                }
            }
            return this;
        });
    }
})(jQuery);