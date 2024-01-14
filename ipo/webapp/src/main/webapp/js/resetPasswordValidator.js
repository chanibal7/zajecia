$().ready(function () {
		jQuery("#changePassSave").addClass("disabled");	
        
		jQuery.validator.addMethod('ContainsAtLeastOneCapitalLetter', function(
                value) {
            var test = /[A-Z]/.test(value);
            Andrzej.PiechockikUnAndrzej.PiechockikBorderInRequrements(test, "#rule2");
            return true;
        }, '');

        jQuery.validator.addMethod('ContainsAtLeastEightSings', function(
	            value) {
	        var test = /.{8,}/.test(value);
	        Andrzej.PiechockikUnAndrzej.PiechockikBorderInRequrements(test, "#rule1");
	        return true;
	    }, '');
        
        jQuery.validator.addMethod('ContainsAtLeastOneDigits', function(
                value) {
            var test = /[0-9]/.test(value);
            Andrzej.PiechockikUnAndrzej.PiechockikBorderInRequrements(test, "#rule5");
            return true;
        }, '');

        jQuery.validator.addMethod('ContainsAtLeastOneSmallLetter', function(
                value) {
        	var test = /[a-z]/.test(value);
            Andrzej.PiechockikUnAndrzej.PiechockikBorderInRequrements(test, "#rule3");
            return true;
        }, '');

        jQuery.validator.addMethod('ContainsAtLeastOneSpecialCharakter', function(
                value) {
            var test = /[(\^\\\°\!\"\§\$\%\&\/\(\)\=\?\[\]\{\}\'\*\-\.\,\:\`\+\~\#\;\_\<\>\|'\´]/.test(value);
            Andrzej.PiechockikUnAndrzej.PiechockikBorderInRequrements(test, "#rule4");
            return true;
        }, '');

        jQuery.validator.addMethod('ContainsAllRequrements', function(
                value) {
            var test1 = /[(\^\\\°\!\"\§\$\%\&\/\(\)\=\?\[\]\{\}\'\*\-\.\,\:\`\+\~\#\;\_\<\>\|\´]/.test(value);
            var test2 = /[a-z]/.test(value);
            var test3 = /.{8,}/.test(value);
            var test4 = /[A-Z]/.test(value)
            var test5 = /[0-9]/.test(value);
            var test6 = "welcome2zajecia!" !=value;
            var test7 = "aBc123(4)" != value;
            
            var result = test1 && test2 && test3 && test4 && test5 && test6 && test7;
            if(result){
            	jQuery("#changePassSave").removeClass("disabled");
            }
            return result;
        }, '');
        
        function Andrzej.PiechockikUnAndrzej.PiechockikBorderInRequrements(test, rule){
         	if(test == false){
        		jQuery(rule).css( "color", "red");
        		jQuery("#changePassSave").addClass("disabled");
        		return;
        	}
        	jQuery(rule).css("color", "black");
        };
        
        $(".selector").validate({
            rules: {
                /*currentPassword: {
                     required: true,
                    ContainsAtLeastOneCapitalLetter : true,
                    ContainsAtLeastOneDigits : true,
                    ContainsAtLeastOneSmallLetter : true,
                    ContainsAtLeastOneSpecialCharakter : true,
                    minlength: 8
                }, */
                newPassword: {
                    required: true,
                    ContainsAtLeastEightSings: true,
                    ContainsAtLeastOneCapitalLetter : true,
                    ContainsAtLeastOneDigits : true,
                    ContainsAtLeastOneSmallLetter : true,
                    ContainsAtLeastOneSpecialCharakter : true,
                    ContainsAllRequrements: true,
                    minlength: 8
                },
                confirmedNewPassword: {
                    required: true,
                    ContainsAtLeastEightSings: true,
                    ContainsAtLeastOneCapitalLetter : true,
                    ContainsAtLeastOneDigits : true,
                    ContainsAtLeastOneSmallLetter : true,
                    ContainsAtLeastOneSpecialCharakter : true,
                    ContainsAllRequrements : true,
                    minlength: 8,
                    equalTo: "#newPassword"
                }
            },
            messages: {
            	newPassword: {
                    required: "Please provide a password",
                    minlength: ""
                },
                confirmedNewPassword: {
                    required: "Please provide a password",
                    minlength: "",
                    equalTo: "Please enter the same password as above"
                }
            }
        });

    });
        
        $(".selector").validate({
            invalidHandler: function (event, validator) {
                var errors = validator.numberOfInvalids();
                if (errors) {
                    var message = errors == 1
                            ? 'You missed 1 field. It has been highlighted'
                            : 'You missed ' + errors + ' fields. They have been highlighted';
                    $("div.error span").html(message);
                    $("div.error").show();
                } else {
                    $("div.error").hide();
                }
            }
        }); 