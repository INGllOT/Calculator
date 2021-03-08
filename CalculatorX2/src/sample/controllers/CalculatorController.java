package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import sample.wb.EvaluateString;

import java.awt.*;

public class CalculatorController {

    @FXML
    private Label  expression;

    @FXML
    private Label result;



    public void insertNumber(String number){
        expression.setText( expression.getText() +number);
    }

    public void insertOperation(String operator){
        expression.setText(expression.getText() + " " + operator + " ");
    }

    public void  clearExpression(){
        expression.setText("");
        result.setText("");

    }
    public Label getExpression(){
        return expression;
    }

    public void setResult(String newResult){
        this.result.setText("= " + newResult);
    }

    public void onMouseClick(MouseEvent mouseEvent) {
        Button button = (Button) mouseEvent.getSource();
        String buttonText = button.getText();



        switch (buttonText){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                insertNumber(buttonText);
                    break;
            case "+":
            case "-":
            case "/":
            case "*":
                insertOperation(buttonText);
                    break;
            case "CLEAR":
                        clearExpression();
                    break;
            case "=":
                double result = EvaluateString.evaluate(this.getExpression().getText());
                setResult(String.valueOf(result));
        }
    }
}
