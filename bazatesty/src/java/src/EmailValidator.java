package src;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
/** @author Konrad*/

@FacesValidator(value = "EmailValidator")
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        /* - dozwolone są duże i małe litery (a–z, A–Z) (ASCII: 65–90, 97–122)
         - dozwolone są cyfry z zakresu od 0 do 9 (ASCII: 48–57)
         - dozwolone są znaki !#$%&'*+-/=?^_`{|}~ 
            (ASCII: 33, 35–39, 42, 43, 45, 47, 61, 63, 94–96, 123–126)
         - dozwolony jest znak . (kropka) (ASCII: 46)
         - adres nie może zaczynać się od cyfry, znaku podkreślenia, 
            kropki a także myślnika (48-57, 46, 45, 95 
         - dozwolone z ograniczeniami są znaki specjalne. Są to: spacja oraz: 
         "(),:;<>@[\] (ASCII: 32, 34, 40, 41, 44, 58, 59, 60, 62, 64, 91–93)*/

        String adres = o.toString();
        FacesMessage msg = new FacesMessage("Niepoprawny adres email", "Niepoprawny adres email");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);

        if (adres.length() > 254)
            throw new ValidatorException(msg);
        
        if (adres.charAt(0)=='_' || adres.charAt(0)=='.' || adres.charAt(0)=='-')
            throw new ValidatorException(msg);
        if (48<adres.charAt(0) && adres.charAt(0)<57)
            throw new ValidatorException(msg);
        
        boolean czyBylaMalpa=false;
        boolean czyBylaKropkaWDomenie=false;
        
        for (int i=0; i<adres.length(); ++i)
        {
            if (32>adres.charAt(i) || adres.charAt(i)>126)
                throw new ValidatorException(msg);
            if (adres.charAt(i)=='@')
                czyBylaMalpa=true;
            if (czyBylaMalpa && adres.charAt(i)=='.')
                czyBylaKropkaWDomenie=true;
        }
        if (!czyBylaMalpa || !czyBylaKropkaWDomenie)
            throw new ValidatorException(msg);

    }

}
