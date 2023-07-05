package za.ac.cput.hackathon2022;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Sbani Sithole
 */
public class UserRegistrationGUI extends JFrame implements ActionListener {

    private JTextField txtName, txtSurname, txtEmail;
    private JPasswordField txtPasword, txtConfrm;
    private JButton btnSave, btnCancel, btnClear;
    private JRadioButton radioMale, radioFemale;
    private JCheckBox agree;
    private JLabel labelTitle, labelName, labelSurname, labelGender, labelEmail, labelPassword, labelConfirm, labelTerms, errName, errSurname, errEmail, errPw, errGender, titleCon;
    private JComboBox title;
    private JPanel panelLeft, panelRight, panelCenter, panelSouth, group;

    public UserRegistrationGUI() {
        super("User Registration");
        //Tetxt Fileds and Password fileds
        txtName = new JTextField();
        txtSurname = new JTextField();
        txtEmail = new JTextField();
        txtPasword = new JPasswordField();
        txtConfrm = new JPasswordField();

        //JPanel
        panelLeft = new JPanel();
        panelRight = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        group = new JPanel();
        panelCenter.setPreferredSize(new Dimension(900 / 3, 500 * 90 / 100));
        panelRight.setPreferredSize(new Dimension(900 / 3, 500 * 90 / 100));
        panelLeft.setPreferredSize(new Dimension(900 / 3, 500 * 90 / 100));
        panelSouth.setPreferredSize(new Dimension(900, 500 * 10 / 100));

        //Button
        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnCancel = new JButton("Exit");
        btnSave.setEnabled(false);

        //Radio Buttons
        radioMale = new JRadioButton("Male");
        radioFemale = new JRadioButton("Female");

        //Labels
        labelTitle = new JLabel("Title");
        labelName = new JLabel("First Name");
        labelSurname = new JLabel("Last Name");
        labelGender = new JLabel("Gender");
        labelEmail = new JLabel("Email");
        labelPassword = new JLabel("Passowrd");
        labelConfirm = new JLabel("Confirm Passowrd");
        labelTerms = new JLabel("Terms and Conditions");
        errName = new JLabel();
        errSurname = new JLabel();
        errEmail = new JLabel();
        errPw = new JLabel();
        errGender = new JLabel();
        titleCon = new JLabel();
        errName.setForeground(Color.red);
        errSurname.setForeground(Color.red);
        errGender.setForeground(Color.red);
        errEmail.setForeground(Color.red);
        errPw.setForeground(Color.red);

        //Combo box
        String elements[] = {"Dr", "Prof", "Mr", "Mrs", "Miss"};
        title = new JComboBox(elements);

        //Check box
        agree = new JCheckBox("Accept terms and conditions");

    }

    public void setGUI() {

        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelRight, BorderLayout.EAST);
        this.add(panelSouth, BorderLayout.SOUTH);

        //Panel Left
        panelLeft.setLayout(new GridLayout(8, 1));
        panelLeft.add(labelTitle);
        panelLeft.add(labelName);
        panelLeft.add(labelSurname);
        panelLeft.add(labelGender);
        panelLeft.add(labelEmail);
        panelLeft.add(labelPassword);
        panelLeft.add(labelConfirm);
        panelLeft.add(labelConfirm);
        panelLeft.add(labelTerms);

        //Panel Right
        panelRight.setLayout(new GridLayout(8, 1));
        panelRight.add(titleCon);
        panelRight.add(errName);
        panelRight.add(errSurname);
        panelRight.add(errGender);
        panelRight.add(errEmail);
        panelRight.add(errPw);

        //panelcenter
        panelCenter.setLayout(new GridLayout(8, 1));
        panelCenter.add(title);
        panelCenter.add(txtName);
        panelCenter.add(txtSurname);
        //panel group
        group.setLayout(new GridLayout(1, 2));
        group.add(radioMale);
        group.add(radioFemale);
        panelCenter.add(group);
        panelCenter.add(txtEmail);
        panelCenter.add(txtPasword);
        panelCenter.add(txtConfrm);
        panelCenter.add(agree);
        agree.addActionListener(this);

        //Panel South
        panelSouth.setLayout(new GridLayout(1, 3));
        panelSouth.add(btnSave);
        panelSouth.add(btnClear);
        panelSouth.add(btnCancel);
        btnCancel.addActionListener(this);
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        radioFemale.addActionListener(this);
        radioMale.addActionListener(this);
        this.setSize(900, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
    }
//Validate Email

    private boolean verifyEmail(String email) {
        String emailReg = "^[A-Z0-9._%+-]+@[A-Z0-9._+-]+\\.[A-Z]{2,6}$";
        Pattern emailVeriify = Pattern.compile(emailReg, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailVeriify.matcher(email);
        return matcher.find();
    }
//Verify EMpty input fields

    private boolean isEmpty() {
        boolean x = true;
        String err = "This filed is empty";
        if (x) {
            if (txtName.getText().isEmpty()) {
                errName.setText(err);
            }
            if (txtSurname.getText().isEmpty()) {
                errSurname.setText(err);
            }
            if (txtEmail.getText().isEmpty()) {
                errEmail.setText(err);
            }
            if (txtPasword.getPassword().length == 0 || txtConfrm.getPassword().length == 0) {
                errPw.setText("Password and confirm password both need to be entered");
            }

            if (radioFemale.isSelected() == false && radioMale.isSelected() == false) {
                errGender.setText("Please select one");
            }
            if (!txtName.getText().isEmpty() && !txtSurname.getText().isEmpty() && !txtEmail.getText().isEmpty() && (txtPasword.getPassword().length > 0 && txtConfrm.getPassword().length > 0) && (radioFemale.isSelected() != false || radioMale.isSelected() != false)) {
                x = false;
            }
        }

        return x;
    }

    //Confirm password
    private boolean verifyPassword() {
        return Arrays.equals(txtPasword.getPassword(), txtConfrm.getPassword());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == radioFemale) {
            radioMale.setSelected(false);
        }
        if (e.getSource() == radioMale) {
            radioFemale.setSelected(false);
        }
        if (e.getSource() == agree) {
            if (!agree.isSelected()) {
                btnSave.setEnabled(false);
            } else {
                btnSave.setEnabled(true);
            }
        }
        if (e.getSource() == btnCancel) {

            System.exit(0);
        }
        if (e.getSource() == btnSave) {
            String name = txtName.getText();
            String surname = txtSurname.getText();
            String gender = "Male";
            String password = txtPasword.getText();
            errName.setText("");
            errSurname.setText("");
            errGender.setText("");
            errEmail.setText("");
            errPw.setText("");
            if (radioFemale.isSelected()) {
                gender = "Female";
            }
            String email = txtEmail.getText();
            if (isEmpty()) {
                JOptionPane.showMessageDialog(null, "Some text fields missig");
            } else if (!verifyEmail(email)) {
                errEmail.setText("Email not valid");
            } else if (!verifyPassword()) {
                errPw.setText("Password and confirm password dont match");
            } else if (txtPasword.getPassword().length < 8 || txtConfrm.getPassword().length < 8) {
                errPw.setText("Password needs to be 8 characters or more");
            } else {
                if (new UserRegistration(title.getSelectedItem().toString(), name, surname, gender, email, password).RehisterUser()) {
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed To add user");
                }
            }

        }else if(e.getSource()==btnClear){
        txtConfrm.setText("");
        txtEmail.setText("");
        txtName.setText("");
        txtPasword.setText("");
        txtSurname.setText("");
        title.setSelectedIndex(0);
        
        }
    }

}
