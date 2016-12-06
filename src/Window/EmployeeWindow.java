package Window;

import DataBaseManagment.EntityDataBase;
import Employee.Employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class EmployeeWindow extends  Gui{
    private JTextField nameField;
    private JTextField lastName;
    private JTextField positionField;
    private JTextField salary;
    private JTextField phone;
    private JButton insertButton;
    private JPanel fieldPanel;
    public EmployeeWindow(EntityDataBase db, double w, double h)
    {
        super(db, w, h);
    }

    public void setEmpoyeeField()
    {
        fieldPanel=new JPanel();
        fieldPanel.setLayout(new GridLayout(11,1));
        insertButton=new JButton("Insert");
        insertButton.addActionListener(this);
        nameField=new JTextField();
        lastName=new JTextField();
        positionField=new JTextField();
        salary=new JTextField();
        phone=new JTextField();
        JTextField nameLabel=new JTextField("Name");
        nameLabel.setEditable(false);
        JTextField lastNameLabel=new JTextField("LastName");
        lastNameLabel.setEditable(false);
        JTextField positionLabel=new JTextField("Position");
         positionLabel.setEditable(false);
        JTextField salaryLabel=new JTextField("Salary");
         salaryLabel.setEditable(false);
        JTextField phoneLabel=new JTextField("Phone");
        phoneLabel.setEditable(false);;
        fieldPanel.add(nameLabel);
        fieldPanel.add(nameField);
        fieldPanel.add(lastNameLabel);
        fieldPanel.add(lastName);
        fieldPanel.add(positionLabel);
        fieldPanel.add(positionField);
        fieldPanel.add(salaryLabel);
        fieldPanel.add(salary);
        fieldPanel.add(phoneLabel);
        fieldPanel.add(phone);
        fieldPanel.add(insertButton);

      // fieldPanel.add(phoneLabel);
      //  fieldPanel.add(phone)
        subPanel.add(fieldPanel);

        validate();
    }
    @Override
    public void insert()
    {
        String fname=nameField.getText().toString();
        String surname=lastName.getText().toString();
        String position=positionField.getText().toString();
        int salaryEmpoyee=Integer.parseInt(salary.getText().toString());
        String phoneEmpoyee=phone.getText().toString();
        Employee employee=new Employee(fname,surname,phoneEmpoyee);
         employee.setPosition(position);
         employee.setSalary(salaryEmpoyee);
        db.insert(employee);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==addButton)
        {
            setEmpoyeeField();
        }
        else if(actionEvent.getSource()==insertButton)
        {
            insert();
        }
    }
}
