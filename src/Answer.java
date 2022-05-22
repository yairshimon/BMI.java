import javax.swing.*;
public class Answer {
    JLabel answer;
    public Answer(float answerUser, double idealWeight , float yourWeight){
            answer = new JLabel("");
            if (answerUser < 15) answer.setText("You Anorexic. your BMI is: " + answerUser );
            if (answerUser > 15 && answerUser < 18.5) answer.setText("You Underweight. your BMI is: " + answerUser);
            if (answerUser >18.5 && answerUser < 24.9) answer.setText("You Normal. your BMI is: " + answerUser);
            if (answerUser > 25 && answerUser < 29) answer.setText ("You Overweight. your BMI is: " + answerUser);
            if (answerUser > 30 && answerUser < 35 ) answer.setText("You Obese. your BMI is: " + answerUser);
            if (answerUser >  35 ) answer.setText("You Extreme Obese. your BMI is: " + answerUser);
            JOptionPane.showMessageDialog(null, answer);
            JOptionPane.showMessageDialog(null, "Your correct weight is " + yourWeight +". ideal weight is " + idealWeight);
    }
}

