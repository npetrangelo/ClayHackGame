
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Creates frame and set its properties.
 */
public class Window extends JFrame implements ActionListener {
	public static int WIDTH = 896;
	public static int HEIGHT = 693;

	private JPanel mainPanel;

	private static Window instance;
	private App app;
	Framework framework;

	private Window() {
		// cam = new CameraOrthographic();

		// Sets the title for this frame.
		this.setTitle("3D Transformation");

		// Sets size of the frame.
		if (false) // Full screen mode
		{
			// Disables decorations for this frame.
			this.setUndecorated(true);
			// Puts the frame to full screen.
			this.setExtendedState(this.MAXIMIZED_BOTH);
		} else // Window mode
		{
			// Size of the frame.
			this.setSize(WIDTH, HEIGHT);
			// this.pack();
			// Puts frame to center of the screen.
			this.setLocationRelativeTo(null);
			// So that frame cannot be resizable by the user.
			this.setResizable(true);
		}

		// Exit the application when user close frame.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		framework = new Framework();
		addKeyListener(framework);
		addMouseMotionListener(framework);
		mainPanel.add(framework);
		// Creates the instance of the Framework.java that extends the
		// Canvas.java and puts it on the frame.
		this.add(mainPanel);

		this.setVisible(true);
		instance = this;
		framework.startGameLoop();
	}

	public static Window getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		// Use the event dispatch thread to build the UI for thread-safety.
		SwingUtilities.invokeLater(() -> new Window());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		app = App.getInstance();
	}
}
