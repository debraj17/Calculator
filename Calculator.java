import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField text;
    JButton[] numberButtons=new JButton[10];
    JButton[] fButtons=new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, eqButton, delButton, clrButton, negButton;
    JPanel panel; 
    
    Font myFont=new Font("Times New Roman", Font.BOLD, 24);

    double num1=0, num2=0, result=0;
    char operators;
    Calculator(){
        frame =new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440,550);
        frame.setLayout(null);
        frame.setBackground(Color.BLACK);
        
        text = new JTextField();
        text.setBounds(50, 25, 300, 50);
        text.setFont(myFont);
        text.setEditable(true);
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        
        fButtons [0] = addButton;
        fButtons [1] = subButton;
        fButtons [2] = mulButton;
        fButtons [3] = divButton;
        fButtons [4] = decButton;
        fButtons [5] = eqButton;
        fButtons [6] = delButton;
        fButtons [7] = clrButton;
        fButtons[8]=negButton;

        for(int i=0;i<9;i++){
            fButtons[i].addActionListener(this);
            fButtons[i].setFont(myFont);
            fButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String. valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);

        }
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.orange);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(text);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        Calculator cal=new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        for (int i = 0; i < 10; i++) {
            if(e.getSource()== numberButtons[i]){
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()== delButton){
            String str=text.getText();
            text.setText("");
            for (int i = 0; i < str.length()-1; i++) {
                text.setText(text.getText()+str.charAt(i));
            }
            

        }
        if(e.getSource()== clrButton){
            text.setText("");
        }
        if(e.getSource()== negButton){
            double d=Double.parseDouble(text.getText());
            d=d*-1;
            text.setText(String.valueOf(d));
        }
        if(e.getSource()== decButton){
            text.setText(text.getText().concat("."));
        }
        if(e.getSource()== addButton){
            num1 = Double.parseDouble(text.getText());
            operators = '+';
            text.setText("");
        }
        if(e.getSource()== subButton){
            num1 = Double.parseDouble(text.getText());
            operators = '-';
            text.setText("");
        }
        if(e.getSource()== mulButton){
            num1 = Double.parseDouble(text.getText());
            operators = '*';
            text.setText("");
        }
        if(e.getSource()== divButton){
            num1 = Double.parseDouble(text.getText());
            operators = '/';
            text.setText("");
        }

        if(e.getSource()== eqButton){
            num2 = Double.parseDouble(text.getText());
            switch(operators){
                case '+':
                    result =num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result= num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;

            }
            text.setText(String.valueOf(result));
            num1=result;
        }

        
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}