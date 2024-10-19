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
    private boolean isErrorDisplayed = false;

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
        if (isErrorDisplayed) {
            return; // Если ошибка отображена, не позволяем вводить цифры
        }
        if (isCalculationComplete) {
            text.setText("");
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

    private void handleOperator(char operator) {
        if (isErrorDisplayed) {
            return; // Не позволяем вводить операторы при отображении ошибки
        }

        String val = text.getText();

        if (!val.isEmpty()) {
            calc.setOp1(Double.parseDouble(val));
            calc.setOperator(operator);
            text.setText("");
        }
    }

    @FXML
    private void onClickEqual() {
        if (isErrorDisplayed) {
            return; // Не позволяем выполнять расчет, пока отображена ошибка
        }
        String val = text.getText();
        try {
            if (calc.getOperator() != '\0' && !val.isEmpty()) {
                calc.setOp2(Double.parseDouble(val));
                calc.calculate();
                if (calc.isError()) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setHeaderText(null); // Можно убрать заголовок
                    a.setContentText("Division by zero is not allowed. Please clear the calculator to proceed.");
                    a.show();
                    isErrorDisplayed = true;
                } else {
                    double result = calc.getResult();
                    // Если результат является целым числом, выводим его как целое число
                    if (result == (int) result) {
                        text.setText(String.valueOf((int) result));
                    } else {
                        text.setText(String.valueOf(result));
                    }
                    isCalculationComplete = true;
                }
                calc.reset();
            }
        } catch (NumberFormatException e) {
            text.setText("Error");
            isErrorDisplayed = true;
        }
    }

    @FXML
    private void onClickClear() {
        calc.reset();
        text.setText("");
        isCalculationComplete = false;
        isErrorDisplayed = false;
    }

    @FXML
    private void onClickDot() {
        if (isErrorDisplayed) {
            return; // Не позволяем вводить точки при отображении ошибки
        }
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

    @FXML
    private void onClickSquareRoot() {
        if (isErrorDisplayed) {
            return; // Не позволяем выполнять операцию при отображении ошибки
        }
        String val = text.getText();
        if (!val.isEmpty()) {
            calc.setOp1(Double.parseDouble(val));
            calc.setOperator('√');
            calc.calculate(); // Выполняем расчет сразу
            if (calc.isError()) {
                text.setText("Error");
                isErrorDisplayed = true; // Устанавливаем флаг ошибки
            } else {
                displayResult(calc.getResult());
                isCalculationComplete = true;
            }
        }
    }

    @FXML
    private void onClickPlusMinus() {
        if (isErrorDisplayed) {
            return; // Не позволяем выполнять операцию при отображении ошибки
        }
        String val = text.getText();
        if (!val.isEmpty()) {
            calc.setOp1(Double.parseDouble(val));
            calc.setOperator('±');
            calc.calculate(); // Выполняем расчет сразу
            if (calc.isError()) {
                text.setText("Error");
                isErrorDisplayed = true; // Устанавливаем флаг ошибки
            } else {
                displayResult(calc.getResult());
                isCalculationComplete = true;
            }
        }
    }

    @FXML
    private void onClickPercentage() {
        if (isErrorDisplayed) {
            return; // Не позволяем выполнять операцию при отображении ошибки
        }
        String val = text.getText();
        if (!val.isEmpty()) {
            calc.setOp1(Double.parseDouble(val));
            calc.setOperator('%');
            calc.calculate(); // Выполняем расчет сразу
            if (calc.isError()) {
                text.setText("Error");
                isErrorDisplayed = true; // Устанавливаем флаг ошибки
            } else {
                displayResult(calc.getResult());
                isCalculationComplete = true;
            }
        }
    }

    // Вспомогательный метод для вывода результата
    private void displayResult(double result) {
        if (result == (int) result) {
            text.setText(String.valueOf((int) result));
        } else {
            text.setText(String.valueOf(result));
        }
    }

}