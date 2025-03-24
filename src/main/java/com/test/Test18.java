package com.test;

import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.ULocale;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import static com.ibm.icu.text.MessageFormat.format;

public class Test18 {
    public static void main(String[] args){
        ULocale uLocale = ULocale.forLanguageTag("ru_RU");
        ResourceBundle resources = ResourceBundle.getBundle( "path.to.messages",
                uLocale.toLocale());
        PluralRules pluralRules = PluralRules.forLocale(uLocale);

        double[] numbers = { 0, 1, 1.5, 2, 2.5, 3, 4, 5, 5.5, 11, 12, 23 };
        for (double number : numbers) {
            String resourceKey = "some.message.plural_form." + pluralRules.select(number);
            String message = "!" + resourceKey + "!";
            try {
                message = resources.getString(resourceKey);
                System.out.println(format(message, uLocale, number));
            } catch (MissingResourceException e) { // Log this }
            }

        }
    }
}
