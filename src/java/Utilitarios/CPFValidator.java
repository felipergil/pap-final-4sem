/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Felipe Rodrigues
 */
public class CPFValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value == null) {
            return;
        }
      String cpf = (String) value;
      if(!validate(cpf)) {
        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Inválido", "Favor informar um CPF válido."));
    }
    }

    public static boolean validate(String inValue) {
        inValue = CPFValidator.getNumbersOnly(inValue);

        /*Caso após a validação o CPF informado tiver menos de
         11 digítos automáticamente assumo que é inválido. */
        if (inValue.length() < 11) {
            return false;
        }
         /*O calculo utilizado para validar um CPF possui um erro,
        quando é passado uma sequencia de números iguais, o calculo
        interpreta como um CPF valido, como por exemplo repetindo o
        número 0, obtemos obviamente a soma 0 e dividando por 11
        temos um resultado 0, logo como o resto é menor que 2,
        este CPF é validado erroniamente, esta verificação anula
        este problema
        
        */
        if (inValue.equals("99999999999") || inValue.equals("11111111111")
        || inValue.equals("22222222222") || inValue.equals("33333333333")
        || inValue.equals("44444444444") || inValue.equals("55555555555")
        || inValue.equals("66666666666") || inValue.equals("77777777777")
        || inValue.equals("88888888888") || inValue.equals("00000000000")){
            return false;
        }

        int iRightDigit1 = CPFValidator.getFirstDigit(inValue);
        int iRightDigit2 = CPFValidator.getSecondDigit(inValue);

        int inputDigit1 = Character.digit(inValue.charAt(9), 10);
        int inputDigit2 = Character.digit(inValue.charAt(10), 10);

        return ((iRightDigit1 == inputDigit1) && (iRightDigit2 == inputDigit2));
    }

    /**
     * Método - Retorna Apenas Números
     *
     * @param inValue - String contendo um CPF formatado ou não.
     * @return String contendo apenas os números recebidos por parâmetro.
     */
    public static String getNumbersOnly(String inValue) {
        String numbers = "";

        for (int idx = 0; idx < inValue.length(); idx++) {
            if (Character.isDigit(inValue.charAt(idx))) {
                numbers += String.valueOf(inValue.charAt(idx));
            }
        }

        return numbers;
    }

    /**
     * Método - Obter Primeiro Dígito
     *
     * @param inValue - String contendo um CPF.
     * @return Inteiro com o valor do primeiro dígito verificado VÁLIDO
     */
    public static int getFirstDigit(String inValue) {
        return CPFValidator.getDigit(inValue, 2, 10);
    }

    /**
     * Método - Obter Segundo Dígito
     *
     * @param inValue - String contendo um CPF.
     * @return Inteiro com o valor do segundo dígito verificado VÁLIDO
     */
    public static int getSecondDigit(String inValue) {
        return CPFValidator.getDigit(inValue, 1, 11);
    }

    /**
     * Método - Obter Dígito
     *
     * @param inValue - String contendo um CPF.
     * @param inSubLength - Inteiro que defini quantos caracteres do final serão
     * desconsiderados
     * @param inMultiplicator - Inteiro que define qual o valor inicial do
     * multiplicador
     * @return Inteiro com o valor do primeiro dígito verificado VÁLIDO
     */
    private static int getDigit(String inValue, int inSubLength, int inMultiplicator) {
        int iAux,
                iRest,
                iDigit,
                iSum = 0,
                iMax = 11 - inSubLength;

        for (int idx = 0; idx < iMax; idx++, inMultiplicator--) {
            iAux = Character.digit(inValue.charAt(idx), 10);
            iSum += iAux * inMultiplicator;
        }

        iRest = iSum % 11;

        if (iRest < 2) {
            iDigit = 0;
        } else {
            iDigit = 11 - iRest;
        }

        return iDigit;
    }   
    
}
