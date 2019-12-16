
package cz.terner.uitest;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyChild {
    private JFrame parent;
    private JDialog dialog;
    private Answer ans;

    public MyChild(JFrame parent) {
        this.parent = parent;
    }
    
    /*private JPanel createPanel() {
        return new Child(this, );
    }*/
    
    void display() {
        dialog = new JDialog(parent, "get", true);
        dialog.setSize(400, 550);
        
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setContentPane(new Child(this, dialog));
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
    }
    
    public void setAns(Answer ans) {
        this.ans = ans;
    }

    public Answer getAns() {
        return ans;
    }

}
