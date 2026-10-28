package br.com.erudio.controllers;

import br.com.erudio.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    public Double sun(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        if(Double.parseDouble(numberOne) >= Double.parseDouble(numberTwo))
            return convertToDouble(numberOne) - convertToDouble(numberTwo);
        return convertToDouble(numberTwo) - convertToDouble(numberOne);
    }

    @RequestMapping("/multi/{numberOne}/{numberTwo}")
    public Double multi(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        if(Double.parseDouble(numberOne) >= Double.parseDouble(numberTwo))
            return convertToDouble(numberOne) / convertToDouble(numberTwo);
        return convertToDouble(numberTwo) / convertToDouble(numberOne);
    }

    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return calAverage(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/squareRoot/{numberOne}")
    public Double mean(
            @PathVariable("numberOne") String number
    ) throws Exception {
        if(!isNumeric(number))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return Math.sqrt(convertToDouble(number));
    }

    private Double calAverage(Double one, Double two){
        return (one + two) / 2;
    }

}
