
package cz.terner.uitest;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class MyDialog {
    private JFrame parent;
    private JDialog dialog;
    private String information;

    MyDialog (JFrame parent)
    {
        this.parent = parent;
    }

    private JPanel createEditBox ()
    {
        JPanel panel = new JPanel ();

        JLabel dialogtitlelabel = new JLabel ("Enter Info");
        panel.add (dialogtitlelabel);
        dialogtitlelabel.setFont (new Font ("Arial", Font.BOLD, 20));


        final JTextArea informationtxt = new JTextArea ();
        informationtxt.setEditable (true);
        informationtxt.setLineWrap (true);
        informationtxt.setWrapStyleWord (true);

        JScrollPane jsp = new JScrollPane (informationtxt);
        jsp.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setHorizontalScrollBarPolicy (ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setPreferredSize (new Dimension (180, 120));
        panel.add (jsp);

        JButton btnok = new JButton ("OK");
        panel.add (btnok);

        JButton btncancel = new JButton ("Cancel");
        panel.add (btncancel);

        btnok.addActionListener (new ActionListener ()
        {
            @Override public void actionPerformed (ActionEvent a)
            {
                if (informationtxt.getText () == null || informationtxt.getText ().isEmpty ())
                {
                    return;
                }

                information = informationtxt.getText ();

                dialog.dispose ();
            }
        });

        btncancel.addActionListener (new ActionListener ()
        {
            @Override public void actionPerformed (ActionEvent a)
            {
                dialog.dispose ();
            }
        });

        return panel;
    }

    void display ()
    {
        final int DWIDTH = 200;
        final int DHEIGHT = 240;

        dialog = new JDialog (parent, "Information", true);
        dialog.setSize (DWIDTH, DHEIGHT);
        dialog.setResizable (false);
        dialog.setDefaultCloseOperation (JDialog.DISPOSE_ON_CLOSE);

        dialog.setContentPane (createEditBox ());

        dialog.setLocationRelativeTo (parent);
        dialog.setVisible (true);
    }

    String getInformation ()
    {
        return information;
    }
}
