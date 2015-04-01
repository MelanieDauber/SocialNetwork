      /*
      THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
      CODE WRITTEN BY OTHER STUDENTS. Melanie Dauber
      */

	package project;

	import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
		 

public class SocialNetwork {
	
	//Create socialBST tree
	public static SocialBST t = new SocialBST();
	
	//checks that two input names exist
	private static boolean checkName(String name){
		boolean flag = true;
        Profile data = t.findProfile(name);
        if (data == null){
        	System.out.println("User does not exist");
        	flag = false;
        }
        return flag;
	}
	
	
	//add new user page
	public static void addNewUser(final Container pane){
		pane.removeAll();
		pane.repaint();
    	JLabel welcome = new JLabel("Welcome to the Social Network made by Jacob Shelley and Melanie Dauber");
    	pane.add(welcome);
    	welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
    	
    	//username text field
    	JLabel nameText = new JLabel("Enter new username");
    	nameText.setAlignmentX(Component.CENTER_ALIGNMENT);
    	pane.add(nameText);
    	
        final JTextField userName = new JTextField();
        userName.setMaximumSize(new Dimension(300, 30));
        userName.setEditable(true);
        pane.add(userName);
        
        //password text field
        JLabel password = new JLabel("Enter new password");
        password.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(password);
        
        final JPasswordField passwordText = new JPasswordField();
        passwordText.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordText.setMaximumSize(new Dimension(300, 30));
        passwordText.setEditable(true);
        pane.add(passwordText);
        
        //input button
        JButton inputButton = new JButton("Input");
        inputButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(inputButton);
        inputButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
                String name = userName.getText();
                @SuppressWarnings("deprecation")
				String password = passwordText.getText();
                Profile data = t.findProfile(name);
                if (data == null){
                	Profile info = new Profile(name, password);
                	t.insert(info);
                } else {
                	System.out.println("Username already exists.");
                }
                userName.setText("");
                passwordText.setText("");
        	}
        });
        
        //home button
        JButton loginButton = new JButton("Back");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
                login(pane);
        	}
        });
        
        pane.validate();
	}

	//search for user
	public static void searchUser(final Container pane, final Profile loggedIn){
		pane.removeAll();
		pane.repaint();
    	JLabel welcome = new JLabel("Welcome to the Social Network made by Jacob Shelley and Melanie Dauber");
    	pane.add(welcome);
    	welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
    	
        final JTextField userName = new JTextField();
        userName.setMaximumSize(new Dimension(300, 30));
        userName.setEditable(true);
        pane.add(userName);
        
        //input button
        JButton inputButton = new JButton("Input");
        inputButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(inputButton);
        inputButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
                String name = userName.getText();
				Profile info = t.findProfile(name);
				if(info==null) System.out.println("Not Found");
				else info.printProfile();
				userName.setText("");
        	}
        });
        
        //home button
        JButton homeButton = new JButton("Home");
        homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(homeButton);
        homeButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
                home(pane, loggedIn);
        	}
        });
        
        pane.validate();
	}
	
	//add friends
	public static void addFriend(final Container pane, final Profile loggedIn){
		pane.removeAll();
		pane.repaint();
    	JLabel welcome = new JLabel("Welcome to the Social Network made by Jacob Shelley and Melanie Dauber");
    	pane.add(welcome);
    	welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel friendText = new JLabel("Friend being added");
        friendText.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(friendText);
        
        final JTextField friendName1 = new JTextField();
        friendName1.setMaximumSize(new Dimension(300, 30));
        friendName1.setEditable(true);
        pane.add(friendName1);
        
        //input button
        JButton inputButton = new JButton("Input");
        inputButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(inputButton);
        inputButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
        		String friendName = friendName1.getText();
                if (checkName(friendName)){
                	Profile info = t.findProfile(friendName);
                	loggedIn.addFriend(info);
                }
				friendName1.setText("");
        	}
        });
        
        //home button
        JButton homeButton = new JButton("Home");
        homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(homeButton);
        homeButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
                home(pane, loggedIn);
        	}
        });
        
        pane.validate();
	}
	
	//remove friends
	public static void removeFriend(final Container pane, final Profile loggedIn){
		pane.removeAll();
		pane.repaint();
    	JLabel welcome = new JLabel("Welcome to the Social Network made by Jacob Shelley and Melanie Dauber");
    	pane.add(welcome);
    	welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel friendText = new JLabel("Friend being removed");
        friendText.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(friendText);
        
        final JTextField friendName1 = new JTextField();
        friendName1.setMaximumSize(new Dimension(300, 30));
        friendName1.setEditable(true);
        pane.add(friendName1);
        
        //input button
        JButton inputButton = new JButton("Input");
        inputButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(inputButton);
        inputButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
        		String friendName = friendName1.getText();
                if (checkName(friendName)){
                	Profile info = t.findProfile(friendName);
                	loggedIn.removeFriend(info);
                }
				friendName1.setText("");
        	}
        });
        
        //home button
        JButton homeButton = new JButton("Home");
        homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(homeButton);
        homeButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
                home(pane, loggedIn);
        	}
        });
        
        pane.validate();
	}
	
	
	//home page
    public static void home(final Container pane, final Profile loggedIn) {
    	pane.removeAll();
    	pane.repaint();
    	    	
    	JLabel welcome = new JLabel("Welcome to the Social Network made by Jacob Shelley and Melanie Dauber");
    	pane.add(welcome);
    	welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //search for user
        JButton button1 = new JButton("Search for a User");
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(button1);
        button1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
               	searchUser(pane, loggedIn);
            }
        });
    
        //add friend
        JButton button2 = new JButton("Add a Friend for a User");
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(button2);
        button2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
                addFriend(pane, loggedIn);
            }
        });
        
        //remove friend
        JButton button3 = new JButton("Remove a Friend for a User");
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(button3);
        button3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
                removeFriend(pane, loggedIn);
            }
        });
        
        //logout
        JButton loginButton = new JButton("Logout");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
                login(pane);
        	}
        });
        
        pane.validate();
    }
    
    //login page
	public static void login(final Container pane){
		pane.removeAll();
		pane.repaint();
    	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

    	JLabel welcome = new JLabel("Welcome to the Social Network made by Jacob Shelley and Melanie Dauber");
    	pane.add(welcome);
    	welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
    	
    	//username text field
        JLabel nameText = new JLabel("Username");
        nameText.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(nameText);
        
        final JTextField userName = new JTextField();
        userName.setMaximumSize(new Dimension(300, 30));
        userName.setEditable(true);
        pane.add(userName);
        
        //password text field
        JLabel password = new JLabel("Password");
        password.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(password);
        
        final JPasswordField passwordText = new JPasswordField();
        passwordText.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordText.setMaximumSize(new Dimension(300, 30));
        passwordText.setEditable(true);
        pane.add(passwordText);
        
        //login button
        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
        		@SuppressWarnings("deprecation")
				String password = passwordText.getText();
        		String name = userName.getText();
        		Profile loggedIn = t.findProfile(name);
        		if (loggedIn == null){
        			System.out.println("Username does not exist");
        		} else if (!loggedIn.password.equals(password)){
        			System.out.println("Incorrect password");
        		} else {
        			System.out.println("Welcome " + name);
        			home(pane, loggedIn);
        		}
        		passwordText.setText("");
        		userName.setText("");
        	}
        });
	
        //new profile button
        JButton button = new JButton("Don't have a profile?");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(button);
        button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
                addNewUser(pane);
        	}
        });
        
        pane.validate();
	}
    
 
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Social Network");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        frame.setLocation(450, 250);
 
        //Set up the content pane.
        login(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

	public static void main(String[] args) {
	    javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            createAndShowGUI();
	        }
	    });
	}
}		
