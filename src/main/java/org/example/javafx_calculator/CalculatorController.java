package org.example.javafx_calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {
    Calculator calc = new Calculator();
    @FXML
    private TextField text;
    private boolean isCalculationComplete = false;

    @FXML
    private void onClick1() {
        handleDigit("1");
    }

    @FXML
    private void onClick2() {
        handleDigit("2");
    }

    @FXML
    private void onClick3() {
        handleDigit("3");
    }

    @FXML
    private void onClick4() {
        handleDigit("4");
    }

    @FXML
    private void onClick5() {
        handleDigit("5");
    }

    @FXML
    private void onClick6() {
        handleDigit("6");
    }

    @FXML
    private void onClick7() {
        handleDigit("7");
    }

    @FXML
    private void onClick8() {
        handleDigit("8");
    }

    @FXML
    private void onClick9() {
        handleDigit("9");
    }

    @FXML
    private void onClick0() {
        handleDigit("0");
    }

    private void handleDigit(String digit) {
        if (isCalculationComplete) {
            text.setText(""); // Очистить перед вводом нового числа
            isCalculationComplete = false;
        }
        String val = text.getText();
        val += digit;
        text.setText(val);
    }

//    @FXML
//    private void onClick1() {
//        String val = text.getText();
//        val = val + "1";
//        text.setText(val);
//    }

//    @FXML
//    private void onClickPlus() {
//        String val = text.getText();
//        calc.setOp1(Integer.parseInt(val));
//        calc.setOperator('+');
//        text.setText("");
//    }

    @FXML
    private void onClickPlus() {
        handleOperator('+');
    }

    @FXML
    private void onClickMinus() {
        handleOperator('-');
    }

    @FXML
    private void onClickMultiply() {
        handleOperator('*');
    }

    @FXML
    private void onClickDivide() {
        handleOperator('/');
    }

    @FXML
    private void onClickPercentage() {
        handleOperator('%');
    }

    @FXML
    private void onClickSquareRoot() {
        handleOperator('√');
    }

    @FXML
    private void onClickPlusMinus() {
        handleOperator('±');
    }

    private void handleOperator(char operator) {
        String val = text.getText();
        if (!val.isEmpty()) {
            calc.setOp1(Double.parseDouble(val));
            calc.setOperator(operator);
            text.setText(""); // Очистить поле для нового операнда
        } else if (operator == '√' || operator == '±') {
            calc.setOp1(calc.getOp1()); // Сохраняем текущее значение
            calc.setOperator(operator);
            calc.calculate(); // Выполняем расчет сразу
            if (calc.isError()) {
                text.setText("Error");
            } else {
                double result = calc.getResult();
                // Проверка на целое число
                if (result == (int) result) {
                    text.setText(String.valueOf((int) result));
                } else {
                    text.setText(String.valueOf(result));
                }
            }
            return;
        }

        if (operator == '%') {
            calc.setOperator(operator);
            // Рассматриваем, что это просто op1 * 0.01
            calc.calculate(); // Выполняем расчет сразу
            if (calc.isError()) {
                text.setText("Error");
            } else {
                double result = calc.getResult();
                if (result == (int) result) {
                    text.setText(String.valueOf((int) result));
                } else {
                    text.setText(String.valueOf(result));
                }
            }
            return;
        }

        calc.setOperator(operator);
        text.setText("");
    }

    @FXML
    private void onClickEqual() {
        String val = text.getText();
        try {
            if (calc.getOperator() != '\0' && !val.isEmpty()) {
                calc.setOp2(Double.parseDouble(val));
                calc.calculate();
                if (calc.isError()) {
                    text.setText("Error: Division by Zero");
                } else {
                    double result = calc.getResult();
                    // Если результат является целым числом, выводим его как целое число
                    if (result == (int) result) {
                        text.setText(String.valueOf((int) result));
                    } else {
                        text.setText(String.valueOf(result));
                    }
                }
                calc.reset();
                isCalculationComplete = true;
            }
        } catch (NumberFormatException e) {
            text.setText("Error");
        }
    }

    @FXML
    private void onClickClear() {
        calc.reset();
        text.setText("");
        isCalculationComplete = false;
    }

    @FXML
    private void onClickDot() {
        String currentText = text.getText();

        // Проверка на наличие точки в текущем операнде
        if (currentText.contains(".")) {
            return; // если точка уже есть, ничего не делаем
        }

        // Если строка пустая, добавляем "0."
        if (currentText.isEmpty()) {
            text.setText("0.");
        } else {
            // Иначе добавляем точку к текущему числу
            text.setText(currentText + ".");
        }
    }
}