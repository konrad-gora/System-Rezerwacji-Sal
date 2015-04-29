package src;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * * @author Konrad
 */

@FacesValidator(value = "PeselValidator")
public class PeselValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        /* 11 znaków, tylko liczby
         przy urodzeniu po 1999r. dodaje się 20 do miesiąca (dalej analogicznie co wiek)
        suma kontrolna */
        String peselString = o.toString();
        FacesMessage msg = new FacesMessage("Niepoprawny PESEL", "Niepoprawny PESEL");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);

        if (peselString.length() != 11){ //czy ma 11 znakow
            throw new ValidatorException(msg);
        }

        int pesel[] = new int[11];
        for (int i = 0; i < 11; ++i) {
            pesel[i] = (int) peselString.charAt(i) - '0';
            System.out.print(pesel[i]);
        }
        System.out.println();

        for (int i = 0; i < 11; ++i) {//czy tylko cyfry
            if (0 > pesel[i] || pesel[i] > 9) {
                throw new ValidatorException(msg);
            }
        }

        if (pesel[2] % 2 == 1 && pesel[3] > 2){ //czy miesiac wyzszy niz 12 
            throw new ValidatorException(msg);
        }

        if (pesel[4] > 3){ //czy dzien wiekszy niz 3x
            throw new ValidatorException(msg);
        }

        if (pesel[4] == 3 && pesel[5] > 1){ //czy dzien wiekszy niz 31
            throw new ValidatorException(msg);
        }

        int sumaKontrolna = 1 * pesel[0] + 3 * pesel[1] + 7 * pesel[2] + 9 * pesel[3] + 1 * pesel[4]
                + 3 * pesel[5] + 7 * pesel[6] + 9 * pesel[7] + 1 * pesel[8] + 3 * pesel[9];
        if (pesel[10] != 10 - sumaKontrolna % 10) {
            throw new ValidatorException(msg);
        }
    }

}
