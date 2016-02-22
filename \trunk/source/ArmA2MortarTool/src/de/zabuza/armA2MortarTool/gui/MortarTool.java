package de.zabuza.armA2MortarTool.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import de.zabuza.armA2MortarTool.calculator.Calculator;
import de.zabuza.armA2MortarTool.calculator.units.Vector;

/**
 * GUI of the tool.
 * 
 * @author Zabuza
 * 
 */
public final class MortarTool {

	/**
	 * The calculator of the tool.
	 */
	private Calculator calculator = new Calculator();
	/**
	 * The frame of the tool.
	 */
	private JFrame frame;
	/**
	 * Textfields of the frame.
	 */
	private JTextField mortarX, mortarY, mortarZ, targetX, targetY, targetZ,
			spotterX, spotterY, spotterZ, actualDist, actualDir, intendedDist,
			intendedDir, distance, direction, heightDif, corDistance,
			corDirection;
	/**
	 * List of all textfields for value checking.
	 */
	private List<JTextField> textFields = new ArrayList<JTextField>();

	/**
	 * Create the tool.
	 */
	public MortarTool() {
		initialize();
	}

	/**
	 * Sets the frames visibility.
	 * 
	 * @param visible
	 *            the visibility to set
	 */
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("ArmA 2 Mortar Tool");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblMortarPosition = new JLabel("Mortar Position:");
		lblMortarPosition.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMortarPosition.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMortarPosition.setBounds(10, 11, 82, 14);
		frame.getContentPane().add(lblMortarPosition);

		JLabel lblTargetPosition = new JLabel("Target Position:");
		lblTargetPosition.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTargetPosition.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTargetPosition.setBounds(10, 36, 82, 14);
		frame.getContentPane().add(lblTargetPosition);

		JLabel lblSpotterPosition = new JLabel("Spotter Position:");
		lblSpotterPosition.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSpotterPosition.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpotterPosition.setBounds(10, 61, 82, 14);
		frame.getContentPane().add(lblSpotterPosition);

		JLabel lblX = new JLabel("X=");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblX.setBounds(102, 11, 14, 14);
		frame.getContentPane().add(lblX);

		mortarX = new JTextField();
		mortarX.setBounds(118, 8, 41, 20);
		frame.getContentPane().add(mortarX);
		mortarX.setColumns(10);

		JLabel lblY = new JLabel("Y=");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblY.setBounds(169, 11, 14, 14);
		frame.getContentPane().add(lblY);

		mortarY = new JTextField();
		mortarY.setColumns(10);
		mortarY.setBounds(185, 8, 41, 20);
		frame.getContentPane().add(mortarY);

		JLabel lblZ = new JLabel("Z=");
		lblZ.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZ.setBounds(236, 11, 14, 14);
		frame.getContentPane().add(lblZ);

		mortarZ = new JTextField();
		mortarZ.setColumns(10);
		mortarZ.setBounds(251, 8, 41, 20);
		frame.getContentPane().add(mortarZ);

		JLabel label = new JLabel("X=");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(102, 36, 14, 14);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("Y=");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(169, 36, 14, 14);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Z=");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(236, 36, 14, 14);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("Z=");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(236, 61, 14, 14);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("Y=");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_4.setBounds(169, 61, 14, 14);
		frame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("X=");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(102, 61, 14, 14);
		frame.getContentPane().add(label_5);

		targetX = new JTextField();
		targetX.setColumns(10);
		targetX.setBounds(118, 33, 41, 20);
		frame.getContentPane().add(targetX);

		spotterX = new JTextField();
		spotterX.setColumns(10);
		spotterX.setBounds(118, 58, 41, 20);
		frame.getContentPane().add(spotterX);

		targetY = new JTextField();
		targetY.setColumns(10);
		targetY.setBounds(185, 33, 41, 20);
		frame.getContentPane().add(targetY);

		spotterY = new JTextField();
		spotterY.setColumns(10);
		spotterY.setBounds(185, 58, 41, 20);
		frame.getContentPane().add(spotterY);

		spotterZ = new JTextField();
		spotterZ.setColumns(10);
		spotterZ.setBounds(251, 58, 41, 20);
		frame.getContentPane().add(spotterZ);

		targetZ = new JTextField();
		targetZ.setColumns(10);
		targetZ.setBounds(251, 33, 41, 20);
		frame.getContentPane().add(targetZ);

		JLabel lblStellig = new JLabel("(4 digits)");
		lblStellig.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblStellig.setBounds(302, 11, 46, 14);
		frame.getContentPane().add(lblStellig);

		JLabel label_6 = new JLabel("(4 digits)");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_6.setBounds(302, 36, 46, 14);
		frame.getContentPane().add(label_6);

		JLabel label_7 = new JLabel("(4 digits)");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_7.setBounds(302, 61, 46, 14);
		frame.getContentPane().add(label_7);

		JLabel lblActualHitPosition = new JLabel("Actual Hit Position:");
		lblActualHitPosition.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblActualHitPosition.setHorizontalAlignment(SwingConstants.RIGHT);
		lblActualHitPosition.setBounds(10, 101, 106, 14);
		frame.getContentPane().add(lblActualHitPosition);

		JLabel lblDistance = new JLabel("Distance=");
		lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDistance.setBounds(134, 89, 49, 14);
		frame.getContentPane().add(lblDistance);

		JLabel lblDirection = new JLabel("Direction=");
		lblDirection.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDirection.setBounds(133, 114, 50, 14);
		frame.getContentPane().add(lblDirection);

		actualDist = new JTextField();
		actualDist.setColumns(10);
		actualDist.setBounds(185, 86, 41, 20);
		frame.getContentPane().add(actualDist);

		actualDir = new JTextField();
		actualDir.setColumns(10);
		actualDir.setBounds(185, 111, 41, 20);
		frame.getContentPane().add(actualDir);

		JLabel lblm = new JLabel("(m)");
		lblm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblm.setBounds(236, 89, 21, 14);
		frame.getContentPane().add(lblm);

		JLabel lblmil = new JLabel("(mil)");
		lblmil.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblmil.setBounds(236, 114, 32, 14);
		frame.getContentPane().add(lblmil);

		JLabel label_8 = new JLabel("Distance=");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_8.setBounds(134, 139, 49, 14);
		frame.getContentPane().add(label_8);

		JLabel label_9 = new JLabel("Direction=");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_9.setBounds(133, 164, 50, 14);
		frame.getContentPane().add(label_9);

		intendedDist = new JTextField();
		intendedDist.setColumns(10);
		intendedDist.setBounds(185, 136, 41, 20);
		frame.getContentPane().add(intendedDist);

		intendedDir = new JTextField();
		intendedDir.setColumns(10);
		intendedDir.setBounds(185, 161, 41, 20);
		frame.getContentPane().add(intendedDir);

		JLabel label_10 = new JLabel("(m)");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_10.setBounds(236, 139, 21, 14);
		frame.getContentPane().add(label_10);

		JLabel label_11 = new JLabel("(mil)");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_11.setBounds(236, 164, 32, 14);
		frame.getContentPane().add(label_11);

		JLabel lblIntendedHitPosition = new JLabel("Intended Hit Position:");
		lblIntendedHitPosition.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIntendedHitPosition.setBounds(10, 152, 106, 14);
		frame.getContentPane().add(lblIntendedHitPosition);

		JLabel lblResults = new JLabel("Results:");
		lblResults.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblResults.setBounds(10, 190, 46, 14);
		frame.getContentPane().add(lblResults);

		JLabel label_12 = new JLabel("Distance=");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setBounds(67, 190, 51, 14);
		frame.getContentPane().add(label_12);

		JLabel label_13 = new JLabel("Direction=");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setBounds(66, 215, 52, 14);
		frame.getContentPane().add(label_13);

		JLabel lblHeightdif = new JLabel("HeightDif=");
		lblHeightdif.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHeightdif.setBounds(66, 240, 52, 14);
		frame.getContentPane().add(lblHeightdif);

		distance = new JTextField();
		distance.setEditable(false);
		distance.setColumns(10);
		distance.setBounds(118, 187, 41, 20);
		frame.getContentPane().add(distance);

		direction = new JTextField();
		direction.setEditable(false);
		direction.setColumns(10);
		direction.setBounds(118, 212, 41, 20);
		frame.getContentPane().add(direction);

		heightDif = new JTextField();
		heightDif.setEditable(false);
		heightDif.setColumns(10);
		heightDif.setBounds(118, 237, 41, 20);
		frame.getContentPane().add(heightDif);

		JLabel label_14 = new JLabel("(m)");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_14.setBounds(169, 189, 21, 14);
		frame.getContentPane().add(label_14);

		JLabel label_15 = new JLabel("(mil)");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_15.setBounds(169, 215, 32, 14);
		frame.getContentPane().add(label_15);

		JLabel label_16 = new JLabel("(m)");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_16.setBounds(169, 240, 21, 14);
		frame.getContentPane().add(label_16);

		JLabel lblCorrection = new JLabel("Correction:");
		lblCorrection.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCorrection.setBounds(203, 190, 54, 14);
		frame.getContentPane().add(lblCorrection);

		JLabel label_17 = new JLabel("Distance=");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		label_17.setBounds(268, 190, 51, 14);
		frame.getContentPane().add(label_17);

		JLabel label_18 = new JLabel("Direction=");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_18.setHorizontalAlignment(SwingConstants.RIGHT);
		label_18.setBounds(268, 215, 52, 14);
		frame.getContentPane().add(label_18);

		corDistance = new JTextField();
		corDistance.setEditable(false);
		corDistance.setColumns(10);
		corDistance.setBounds(319, 187, 41, 20);
		frame.getContentPane().add(corDistance);

		corDirection = new JTextField();
		corDirection.setEditable(false);
		corDirection.setColumns(10);
		corDirection.setBounds(319, 212, 41, 20);
		frame.getContentPane().add(corDirection);

		JLabel label_19 = new JLabel("(m)");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_19.setBounds(370, 190, 21, 14);
		frame.getContentPane().add(label_19);

		JLabel label_20 = new JLabel("(mil)");
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_20.setBounds(370, 215, 32, 14);
		frame.getContentPane().add(label_20);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 183, 414, 3);
		frame.getContentPane().add(separator);

		JLabel lblByZabuzaw = new JLabel("by Zabuza (W)");
		lblByZabuzaw.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblByZabuzaw.setBounds(362, 258, 82, 14);
		frame.getContentPane().add(lblByZabuzaw);

		JButton btnCalc = new JButton("Calculate");
		btnCalc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent ae) {
				// Check for NaN
				for (JTextField field : textFields) {
					try {
						Double.parseDouble(field.getText());
					} catch (NumberFormatException ex) {
						field.setText("0");
					}
				}
				calculator.setMortarPos(new Vector(Integer.parseInt(mortarX
						.getText()), Integer.parseInt(mortarY.getText()),
						Integer.parseInt(mortarZ.getText())));
				calculator.setTargetPos(new Vector(Integer.parseInt(targetX
						.getText()), Integer.parseInt(targetY.getText()),
						Integer.parseInt(targetZ.getText())));
				calculator.setSpotterPos(new Vector(Integer.parseInt(spotterX
						.getText()), Integer.parseInt(spotterY.getText()),
						Integer.parseInt(spotterZ.getText())));
				calculator.setActualDirMil(Double.parseDouble(actualDir
						.getText()));
				calculator.setActualDist(Double.parseDouble(actualDist
						.getText()));
				calculator.setIntendedDirMil(Double.parseDouble(intendedDir
						.getText()));
				calculator.setIntendedDist(Double.parseDouble(intendedDist
						.getText()));
				calculator.calculate();
				distance.setText(calculator.getDistance() + "");
				direction.setText(calculator.getDirection() + "");
				heightDif.setText(calculator.getHeightDif() + "");
				corDistance.setText(calculator.getCorDistance() + "");
				corDirection.setText(calculator.getCorDirection() + "");
			}
		});
		btnCalc.setBounds(319, 155, 89, 23);
		frame.getContentPane().add(btnCalc);

		textFields.add(mortarX);
		textFields.add(mortarY);
		textFields.add(mortarZ);
		textFields.add(targetX);
		textFields.add(targetY);
		textFields.add(targetZ);
		textFields.add(spotterX);
		textFields.add(spotterY);
		textFields.add(spotterZ);
		textFields.add(actualDist);
		textFields.add(actualDir);
		textFields.add(intendedDist);
		textFields.add(intendedDir);
	}
}
