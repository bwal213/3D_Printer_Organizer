import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class GetFile {
	private static Text text;
	private static Text text_1;
	private static Text text_PSW;
	private static Text text_PSH;
	
	static String filePath;
	static int numOfObjects;
	/**
	 * Launch the application.
	 * @param args
	 */
	GetFile(){
		filePath = "";
		numOfObjects = 0;
	}
	
	public String getPath(){
		return filePath;
	}
	
	public int getNumObjects() {
		return numOfObjects;
	}
	
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Config");
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Gcode Files", "gcode");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filter);
		
		Label lblNumberOfObjects = new Label(shell, SWT.NONE);
		lblNumberOfObjects.setBounds(23, 95, 109, 15);
		lblNumberOfObjects.setText("Number of Objects:");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(135, 92, 76, 21);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				fileChooser.showOpenDialog(null);
				java.io.File file = fileChooser.getSelectedFile();
				text_1.setText(""+file);
				filePath = ""+file;
			}
		});

		btnNewButton.setBounds(327, 32, 75, 25);
		btnNewButton.setText("Browse");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(23, 32, 298, 25);
		
		Label lblPrintSurfaceWidth = new Label(shell, SWT.NONE);
		lblPrintSurfaceWidth.setBounds(23, 125, 109, 15);
		lblPrintSurfaceWidth.setText("Print surface width:");
		
		text_PSW = new Text(shell, SWT.BORDER);
		text_PSW.setBounds(135, 122, 76, 21);
		
		Label lblPrintSurfaceHeight = new Label(shell, SWT.NONE);
		lblPrintSurfaceHeight.setBounds(23, 145, 109, 15);
		lblPrintSurfaceHeight.setText("Print surface height:");
		
		text_PSW = new Text(shell, SWT.BORDER);
		text_PSW.setBounds(135, 142, 76, 21);
		
		Button btnGo = new Button(shell, SWT.NONE);
		btnGo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (text_1.getText().length() == 0) {
					
				}
				else {
					numOfObjects = Integer.parseInt(text.getText());
					shell.dispose();
				}
			}
		});
		btnGo.setBounds(178, 205, 75, 25);
		btnGo.setText("Go");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
