
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.table.*;
import java.util.*;
public class LoanAssistant extends JFrame
{
    JLabel balanceLabel = new JLabel();
    JTextField balanceTextField = new JTextField();
    JLabel interestLabel = new JLabel();
    JTextField interestTextField = new JTextField();
    JLabel monthsLabel = new JLabel();
    JTextField monthsTextField = new JTextField();
    JLabel paymentLabel = new JLabel();
    JTextField paymentTextField = new JTextField();
    JButton computeButton = new JButton();
    JButton newLoanButton = new JButton();
    JButton monthsButton = new JButton();
    JButton balanceButton = new JButton();
    JButton paymentButton = new JButton();
    JLabel dateLabel = new JLabel();
    JLabel monthLabel = new JLabel();
    JLabel yearLabel = new JLabel();
    JLabel analysisLabel = new JLabel();
    JTextArea analysisTextArea = new JTextArea();
    JLabel rescheduleLabel = new JLabel();
    JButton exitButton = new JButton();
    JButton stopLoanButton = new JButton();
    JButton repaymentButton = new JButton();
    JButton singlePaymentButton = new JButton();
    JScrollPane scroll;
    JLabel startDateLabel =new JLabel();
    JLabel endDateLabel=new JLabel();
    double data[][];
    double totalInterest;
    JTextField startDateTextField =new JTextField();
    JTextField endDateTextField =new JTextField();
    DateFormat format =new SimpleDateFormat("dd/mm/yyyy");
    JLabel singlePaymentLabel = new JLabel();
    JLabel eachMonthDeceasedBalance = new JLabel();
    JLabel eachMonthPaidInterest = new JLabel();
    JTextField eachMonthPaidInterestTextField = new JTextField();
    JTextField eachMonthDeceasedBalanceTextField = new JTextField();
    JTextArea rescheduleTextArea = new JTextArea();
    Font myFont = new Font("Arial", Font.PLAIN, 16);
    Color lightYellow = new Color(255, 255, 128);
    boolean computePayment;
    public static void main(String args[])
    {
// create frame
        new LoanAssistant().show();
    }
    public LoanAssistant()
    {
// frame constructor
        setTitle("Loan Assistant");
        setResizable(false);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                exitForm(evt);
            }
        });
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints;
        balanceLabel.setText("Loan Balance");
        balanceLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        getContentPane().add(balanceLabel, gridConstraints);
        balanceTextField.setPreferredSize(new Dimension(100, 25));
        balanceTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        balanceTextField.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(balanceTextField, gridConstraints);
        balanceTextField.addActionListener(new ActionListener ()
        {
            public void actionPerformed(ActionEvent e)
            {
                balanceTextField.transferFocus();
            }
        });
        interestLabel.setText("Interest Rate");
        interestLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        getContentPane().add(interestLabel, gridConstraints);
        interestTextField.setPreferredSize(new Dimension(100, 25));
        interestTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        interestTextField.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(interestTextField, gridConstraints);
        interestTextField.addActionListener(new ActionListener ()
        {
            public void actionPerformed(ActionEvent e)
            {
                interestTextField.transferFocus();
            }
        });
        monthsLabel.setText("Number of Payments");
        monthsLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        getContentPane().add(monthsLabel, gridConstraints);
        monthsTextField.setPreferredSize(new Dimension(100, 25));
        monthsTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        monthsTextField.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(monthsTextField, gridConstraints);
        monthsTextField.addActionListener(new ActionListener ()
        {
            public void actionPerformed(ActionEvent e)
            {
                monthsTextField.transferFocus();
            }
        });
        paymentLabel.setText("Monthly Payments");
        paymentLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        getContentPane().add(paymentLabel, gridConstraints);
        paymentTextField.setPreferredSize(new Dimension(100, 25));
        paymentTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        paymentTextField.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 3;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(paymentTextField, gridConstraints);
        paymentTextField.addActionListener(new ActionListener ()
        {
            public void actionPerformed(ActionEvent e)
            {
                paymentTextField.transferFocus();
            }
        });

        startDateLabel.setText("Loan Start Date:");
        startDateLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        getContentPane().add(startDateLabel, gridConstraints);
        startDateTextField.setPreferredSize(new Dimension(100, 25));
        startDateTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        startDateTextField.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 4;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(startDateTextField, gridConstraints);
        startDateTextField.addActionListener(new ActionListener ()
        {
            public void actionPerformed(ActionEvent e)
            {
                startDateTextField.transferFocus();
            }
        });
        endDateLabel.setText("Loan End Date:");
        endDateLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 5;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        getContentPane().add(endDateLabel, gridConstraints);
        endDateTextField.setPreferredSize(new Dimension(100, 25));
        endDateTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        endDateTextField.setFont(myFont);
        endDateTextField.setEditable(false);
        endDateTextField.setBackground(lightYellow);
        endDateTextField.setFocusable(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 5;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(endDateTextField, gridConstraints);
        stopLoanButton.setText("Stop Loan");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 6;
        gridConstraints.insets = new Insets(10, 0, 0, 10);
        getContentPane().add(stopLoanButton, gridConstraints);
        stopLoanButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                stopLoanButtonActionPerformed(e);
            }
        });
        computeButton.setText("Compute Monthly Payment");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 6;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(computeButton, gridConstraints);
        computeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                computeButtonActionPerformed(e);
            }
        });
        newLoanButton.setText("New Loan Analysis");
        newLoanButton.setEnabled(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 7;
        gridConstraints.gridwidth = 1;
        gridConstraints.insets = new Insets(10, 0, 10, 0);
        getContentPane().add(newLoanButton, gridConstraints);
        newLoanButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                newLoanButtonActionPerformed(e);
            }
        });
        repaymentButton.setText("Compute Repayment Schedule");
        repaymentButton.setEnabled(true);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 7;
        gridConstraints.gridwidth = 1;
        gridConstraints.insets = new Insets(10, 0, 10, 0);
        getContentPane().add(repaymentButton, gridConstraints);
        repaymentButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                repaymentButtonActionPerformed(e);
            }
        });
        monthsButton.setText("X");
        monthsButton.setFocusable(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(monthsButton, gridConstraints);
        monthsButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                monthsButtonActionPerformed(e);
            }
        });
        balanceButton.setText("X");
        balanceButton.setFocusable(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(balanceButton, gridConstraints);
        balanceButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                balanceButtonActionPerformed(e);
            }
        });
        paymentButton.setText("X");
        paymentButton.setFocusable(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 3;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(paymentButton, gridConstraints);
        paymentButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                paymentButtonActionPerformed(e);
            }
        });
        singlePaymentLabel.setText("Single Payment Processing(per month):");
        singlePaymentLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(singlePaymentLabel, gridConstraints );
        eachMonthDeceasedBalance.setText("Decreased Balance:");
        eachMonthDeceasedBalance.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(eachMonthDeceasedBalance, gridConstraints );
        eachMonthPaidInterest.setText("Paid Interest Per Month:");
        eachMonthPaidInterest.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(eachMonthPaidInterest, gridConstraints );
        eachMonthDeceasedBalanceTextField.setPreferredSize(new Dimension(100, 25));
        eachMonthDeceasedBalanceTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        eachMonthDeceasedBalanceTextField.setFont(myFont);
        eachMonthDeceasedBalanceTextField.setEditable(false);
        eachMonthDeceasedBalanceTextField.setBackground(lightYellow);
        eachMonthDeceasedBalanceTextField.setFocusable(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 4;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(eachMonthDeceasedBalanceTextField, gridConstraints);
        eachMonthPaidInterestTextField.setPreferredSize(new Dimension(100, 25));
        eachMonthPaidInterestTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        eachMonthPaidInterestTextField.setFont(myFont);
        eachMonthPaidInterestTextField.setEditable(false);
        eachMonthPaidInterestTextField.setBackground(lightYellow);
        eachMonthPaidInterestTextField.setFocusable(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 4;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(eachMonthPaidInterestTextField, gridConstraints);

        singlePaymentButton.setText("Compute Single Payment Processing");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 6;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(singlePaymentButton, gridConstraints);
        singlePaymentButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                singlePaymentButtonActionPerformed(e);
            }
        });
        analysisLabel.setText("Loan Analysis:");
        analysisLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 5;
        gridConstraints.gridy = 0;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(0, 10, 0, 0);
        getContentPane().add(analysisLabel, gridConstraints);
        analysisTextArea.setPreferredSize(new Dimension(250, 150));
        analysisTextArea.setFocusable(false);
        analysisTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        analysisTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        analysisTextArea.setEditable(false);
        analysisTextArea.setBackground(Color.WHITE);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 5;
        gridConstraints.gridy = 1;
        gridConstraints.gridheight = 6;
        gridConstraints.insets = new Insets(0, 10, 0, 10);
        getContentPane().add(analysisTextArea, gridConstraints);
        exitButton.setText("Exit");
        exitButton.setFocusable(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 5;
        gridConstraints.gridy = 7;
        getContentPane().add(exitButton, gridConstraints);
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        rescheduleLabel.setText("Loan Reschedule Payment:");
        rescheduleLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 6;
        gridConstraints.gridy = 0;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        getContentPane().add(rescheduleLabel, gridConstraints);
        rescheduleTextArea.setText("");
        scroll = new JScrollPane(rescheduleTextArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        rescheduleTextArea.setPreferredSize(new Dimension(250, 150));
        rescheduleTextArea.setFocusable(false);
        rescheduleTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rescheduleTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        rescheduleTextArea.setEditable(false);
        rescheduleTextArea.setBackground(Color.WHITE);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 6;
        gridConstraints.gridy = 1;
        gridConstraints.gridheight = 6;
        gridConstraints.insets = new Insets(0, 10, 0, 10);
        getContentPane().add(scroll, gridConstraints );
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
        paymentButton.doClick();
    }
    private void exitForm(WindowEvent evt)
    {
        System.exit(0);
    }
    private void computeButtonActionPerformed(ActionEvent e)
    {
        double balance, interest, payment;
        int months;
        double monthlyInterest, multiplier;
        double loanBalance, finalPayment;

        if (validateDecimalNumber(interestTextField)) {
            if (Double.valueOf(interestTextField.getText()).doubleValue() <= 100) {
                interest = Double.valueOf(interestTextField.getText()).doubleValue();
            } else {
                JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPlease correct.", "Interest Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                interestTextField.setText("");
                interestTextField.requestFocus();
                return;
            }
        }
        else
        {
            JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPlease correct.", "Interest Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        monthlyInterest = interest / 1200;
        if (computePayment)
        {
            if (validateDecimalNumber(balanceTextField))
            {
                balance = Double.valueOf(balanceTextField.getText()).doubleValue();
            }
            else
            {
                JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPlease correct.", "Balance Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
// Compute loan payment
            if (validateDecimalNumber(monthsTextField))
            {
                if((Integer.valueOf(monthsTextField.getText()).intValue())>balance)
                {
                    monthsTextField.setText("");
                    JOptionPane.showConfirmDialog(null, "Number of Payments should be atleast less than loan balance entry.\nPlease correct.", "Number of Payments Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    monthsTextField.requestFocus();
                    return;
                }
                else {
                    months = Integer.valueOf(monthsTextField.getText()).intValue();
                }
            }
            else
            {
                JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Payments entry.\nPlease correct.", "Number of Payments Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (interest == 0)
            {
                payment = balance / months;
            }
            else
            {
                multiplier = Math.pow(1 + monthlyInterest, months);
                payment = balance * monthlyInterest * multiplier / (multiplier - 1);
            }
            paymentTextField.setText(new DecimalFormat("0.00").format(payment));
        }
        else
        {
            if(computeButton.getText().equals("Compute Balance")) {
                if (validateDecimalNumber(paymentTextField)) {
                    payment = Double.valueOf(paymentTextField.getText()).doubleValue();
                } else {
                    JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Payment entry.\nPlease correct.", "Payment Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (validateDecimalNumber(monthsTextField)) {
                    months = Integer.valueOf(monthsTextField.getText()).intValue();
                } else {
                    JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Payments entry.\nPlease correct.", "Number of Payments Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (interest == 0) {
                    balance = months * payment;
                } else {
                    balance = payment * (1-(1/Math.pow((1+monthlyInterest),months))) / monthlyInterest;
                }
                balanceTextField.setText(new DecimalFormat("0.00").format(balance));
            }
            else {
                if (validateDecimalNumber(balanceTextField)) {
                    balance = Double.valueOf(balanceTextField.getText()).doubleValue();
                } else {
                    JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPlease correct.", "Balance Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
// Compute number of payments
                if (validateDecimalNumber(paymentTextField)) {
                    payment = Double.valueOf(paymentTextField.getText()).doubleValue();
                    if (payment <= (balance * monthlyInterest + 1.0)) {
                        if (JOptionPane.showConfirmDialog(null, "Minimum payment must be $" + new DecimalFormat("0.00").format((int) (balance * monthlyInterest + 1.0)) + "\n" + "Do you want to use the minimum payment?", "Input Error", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                            paymentTextField.setText(new DecimalFormat("0.00").format((int) (balance * monthlyInterest + 1.0)));
                            payment = Double.valueOf(paymentTextField.getText()).doubleValue();
                        } else {
                            paymentTextField.requestFocus();
                            return;
                        }
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Payment entry.\nPlease correct.", "Payment Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (interest == 0) {
                    months = (int) (balance / payment);
                } else {
                    months = (int) ((Math.log(payment) - Math.log(payment - balance * monthlyInterest)) / Math.log(1 + monthlyInterest));
                }
                monthsTextField.setText(String.valueOf(months));
            }
        }
        if (computeButton.getText().equals("Compute Balance")){
            payment = Double.valueOf(paymentTextField.getText()).doubleValue();
            interest = Double.valueOf(interestTextField.getText()).doubleValue();
            months = Integer.parseInt(monthsTextField.getText());

            analysisTextArea.setText("Affordable money: $" + new DecimalFormat("0.00").format(payment));
            analysisTextArea.append("\n"+"How long you can pay: "+String.valueOf(months));
            analysisTextArea.append("\n"+"Interest Rate: " + new DecimalFormat("0.00").format(interest)+"%");
            analysisTextArea.append("\n\n"+"you can Borrow $" + new DecimalFormat("0.00").format(balance));
            analysisTextArea.append("\n" + "Interest Paid $" + new DecimalFormat("0.00").format((months* payment) - balance));
            totalInterest = (months* payment) - balance;
            computeButton.setEnabled(false);
            newLoanButton.setEnabled(true);
            newLoanButton.requestFocus();
        }
        else {
// reset payment prior to analysis to fix at two decimals
            payment = Double.valueOf(paymentTextField.getText()).doubleValue();
// show analysis
            analysisTextArea.setText("Loan Balance: $" + new DecimalFormat("0.00").format(balance));
            analysisTextArea.append("\n" + "Interest Rate: " + new DecimalFormat("0.00").format(interest) + "%");
// process all but last payment
            loanBalance = balance;
            for (int paymentNumber = 1; paymentNumber <= months - 1; paymentNumber++) {
                loanBalance += loanBalance * monthlyInterest - payment;
            }

// find final payment
            finalPayment = loanBalance;
            if (finalPayment > payment) {
// apply one more payment
                loanBalance += loanBalance * monthlyInterest - payment;
                finalPayment = loanBalance;
                months++;
                monthsTextField.setText(String.valueOf(months));
            }
            if (((months - 1) * payment + finalPayment) < 0) {
                analysisTextArea.setText("");
                monthsTextField.setText("");
                paymentTextField.setText("");
                JOptionPane.showConfirmDialog(null, "Your monthly payment should be less than Total Payments.\nPlease correct.", "Payment Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                paymentTextField.requestFocus();
                return;
            } else {
                analysisTextArea.append("\n\n" + String.valueOf(months - 1) + " Payments of $" + new DecimalFormat("0.00").format(payment));
                analysisTextArea.append("\n" + "Final Payment of: $" + new DecimalFormat("0.00").format(finalPayment));
                analysisTextArea.append("\n" + "Total Payments: $" + new DecimalFormat("0.00").format((months - 1) * payment + finalPayment));
                analysisTextArea.append("\n" + "Interest Paid $" + new DecimalFormat("0.00").format((months - 1) * payment + finalPayment - balance));
                totalInterest = (months - 1) * payment + finalPayment - balance;
                computeButton.setEnabled(false);
                newLoanButton.setEnabled(true);
                newLoanButton.requestFocus();
            }
        }
        if(dateValidation(startDateTextField.getText())){

            String sdate = startDateTextField.getText();
            int tmonth=Integer.valueOf(sdate.substring(3,5)).intValue();
            tmonth = tmonth + Integer.valueOf(monthsTextField.getText()).intValue();
            int month = tmonth % 12;
            if(month == 0){
                month=12;
            }
            int year = Integer.valueOf(sdate.substring(6,10)).intValue() + (int)(tmonth /12);
            String edate = sdate.substring(0,2)+"/"+month+"/"+year;
            endDateTextField.setText(String.valueOf(edate));

        }else {
        JOptionPane.showConfirmDialog(null, "Invalid or Empty Loan Starting Date\nPlease correct.", "Loan Starting Date Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        startDateTextField.setText("");
        startDateTextField.requestFocus();
            return;
        }
    }
    private void newLoanButtonActionPerformed(ActionEvent e)
    {
// clear computed value and analysis
        if (computePayment)
        {
            paymentTextField.setText("");
        }
        else
        {
            if(computeButton.getText().equals("Compute Balance")){
                balanceTextField.setText("");
            } else {
                monthsTextField.setText("");
            }
        }
        analysisTextArea.setText("");
        computeButton.setEnabled(true);
        newLoanButton.setEnabled(false);
        balanceTextField.requestFocus();
    }
    private void monthsButtonActionPerformed(ActionEvent e)
    {
// will compute months
        computePayment = false;
        paymentButton.setVisible(true);
        balanceButton.setVisible(false);
        monthsButton.setVisible(false);
        monthsTextField.setText("");
        monthsTextField.setEditable(false);
        monthsTextField.setBackground(lightYellow);
        monthsTextField.setFocusable(false);
        paymentTextField.setEditable(true);
        balanceTextField.setEditable(true);
        paymentTextField.setBackground(Color.WHITE);
        balanceTextField.setBackground(Color.WHITE);
        paymentTextField.setFocusable(true);
        balanceTextField.setFocusable(true);
        computeButton.setText("Compute Number of Payments");
        balanceTextField.requestFocus();
    }
    private void balanceButtonActionPerformed(ActionEvent e)
    {
// will compute balance
        computePayment = false;
        balanceButton.setVisible(false);
        paymentButton.setVisible(false);
        monthsButton.setVisible(true);
        balanceButton.setText("X");
        balanceTextField.setText("");
        balanceTextField.setEditable(false);
        balanceTextField.setBackground(lightYellow);
        monthsTextField.setFocusable(true);
        balanceTextField.setFocusable(false);
        paymentTextField.setEditable(true);
        paymentTextField.setBackground(Color.WHITE);
        monthsTextField.setBackground(Color.WHITE);
        paymentTextField.setFocusable(true);
        computeButton.setText("Compute Balance");
        interestTextField.requestFocus();
    }
    private void paymentButtonActionPerformed(ActionEvent e)
    {
// will compute payment
        computePayment = true;
        paymentButton.setVisible(false);
        monthsButton.setVisible(false);
        balanceButton.setVisible(true);
        monthsTextField.setEditable(true);
        balanceTextField.setEditable(true);
        monthsTextField.setBackground(Color.WHITE);
        monthsTextField.setFocusable(true);
        balanceTextField.setBackground(Color.WHITE);
        balanceTextField.setFocusable(true);
        paymentTextField.setText("");
        paymentTextField.setEditable(false);
        paymentTextField.setBackground(lightYellow);
        paymentTextField.setFocusable(false);
        computeButton.setText("Compute Monthly Payment");
        balanceTextField.requestFocus();
    }
    private void singlePaymentButtonActionPerformed(ActionEvent e)
    {
        computeButton.doClick();
        double months = Double.valueOf(monthsTextField.getText()).doubleValue();
        double balance = Double.valueOf(balanceTextField.getText()).doubleValue();
        double payment = Double.valueOf(paymentTextField.getText()).doubleValue();

        double perMonthInterest = totalInterest / months;
        double decreasedBalance = payment - perMonthInterest;

        eachMonthDeceasedBalanceTextField.setText(new DecimalFormat("0.00").format(decreasedBalance));
        eachMonthPaidInterestTextField.setText(new DecimalFormat("0.00").format(perMonthInterest));
    }
    void repaymentButtonActionPerformed(ActionEvent e){
        computeButton.doClick();

        int months = Integer.valueOf(monthsTextField.getText()).intValue();
        double payment = Double.valueOf(paymentTextField.getText()).doubleValue();
        double interest = Double.valueOf(interestTextField.getText()).doubleValue();
        double balance = Double.valueOf(balanceTextField.getText()).doubleValue();
        double principalPayment;
        double outstandingBalance;
        double interestPayment;
        double interestToDate=0;
        rescheduleTextArea.setText("Month  |Total Payment |Principal Payment |Interest Payment |Interest to Date |Outstanding Loan Balance");
        for(int i=0;i<=months;i++) {
            outstandingBalance = balance - (i * payment);
            principalPayment = payment - (outstandingBalance * (interest / 1200));
            interestPayment = payment - principalPayment;
            interestToDate += interestPayment;
            balance = balance - payment;
            rescheduleTextArea.append("\nMonth "+i+"\t|"+payment+"\t|"+principalPayment+"\t|"+interestPayment+"\t|"+interestToDate+"\t|"+outstandingBalance+"\t");
        }
    }
    private boolean validateDecimalNumber(JTextField tf)
    {
// checks to see if text field contains
// valid decimal number with only digits and a single decimal point
        String s = tf.getText().trim();
        boolean hasDecimal = false;
        boolean valid = true;
        if (s.length() == 0)
        {
            valid = false;
        }
        else
        {
            for (int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9')
                {
                    continue;
                }
                else if (c == '.' && !hasDecimal)
                {
                    hasDecimal = true;
                }
                else
                {
// invalid character found
                    valid = false;
                }
            }
        }
        tf.setText(s);
        if (!valid)
        {
            tf.requestFocus();
        }
        return (valid);
    }
    boolean dateValidation(String date){
        format.setLenient(false);

            try {
                format.parse(startDateTextField.getText());
            } catch (ParseException pe) {
                return false;
            }
        if(date.length() == 10) {
            return true;
        }
        else{
            JOptionPane.showConfirmDialog(null, "Loan Starting Date length should be 10 and format should be dd/mm/yyyy\nPlease correct.", "Loan Starting Date Instruction", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            startDateTextField.setText("");
            startDateTextField.requestFocus();
            return false;
        }
    }
    void stopLoanButtonActionPerformed(ActionEvent e) {
        computeButton.doClick();
        int stopMonth =Integer.valueOf(JOptionPane.showInputDialog("After how many moths you want to stop Loan:")).intValue();

        double outStandBal = Double.valueOf(balanceTextField.getText()).doubleValue() - (stopMonth * Double.valueOf(paymentTextField.getText()).doubleValue());
        analysisTextArea.setText("Loan Balance: $" + balanceTextField.getText());
        analysisTextArea.append("\n"+"Interest: "+interestTextField.getText()+"%");
        analysisTextArea.append("\n\n"+"You have to pay $"+paymentTextField.getText()+" \nfor "+stopMonth+" months");
        analysisTextArea.append("\nAfter this if you want to \nskip loan then you have to \npay $"+outStandBal);
    }
}