import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class MedicalGUI extends JFrame {
    
    // --- Enhanced Color Palette for a Soothing Medical/UI Feel ---
    private static final Color PRIMARY_BLUE = new Color(52, 152, 219); // Changed from Red to Blue for Soothing/Trust
    private static final Color PRIMARY_RED = new Color(220, 53, 69); // Used for Danger/Action
    private static final Color ACCENT_LIGHT_BLUE = new Color(212, 235, 252);
    private static final Color ACCENT_DARK_BLUE = new Color(41, 128, 185);
    private static final Color WHITE = Color.WHITE;
    private static final Color BACKGROUND_GRAY = new Color(236, 240, 241); // Soothing background
    private static final Color TEXT_DARK = new Color(44, 62, 80); // Darker text for readability
    private static final Color ACCENT_GREEN = new Color(40, 167, 69); // Active/Success
    private static final Color ACCENT_ORANGE = new Color(253, 126, 20); // Warning/Overdue

    private List<Medicine> prescriptionList = new ArrayList<>();
    private Patient currentPatient;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    
    private JPanel dashboardPanel;
    private JPanel schedulePanel;
    private JPanel markDosePanel;
    private JPanel statusPanel;
    private JPanel calculatePanel;
    private JPanel detailsPanel;
    
    // Fixed size for side menu buttons for consistency
    private static final Dimension MENU_BUTTON_SIZE = new Dimension(200, 45); 
    
    public MedicalGUI() {
        setTitle("Medical Reminder System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 750); // Slightly larger frame
        setLocationRelativeTo(null);
        
        showPatientRegistration();
    }
    
    private void showPatientRegistration() {
        JPanel registrationPanel = new JPanel(new GridBagLayout());
        registrationPanel.setBackground(BACKGROUND_GRAY); // Use softer background
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // --- Central Registration Card ---
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(ACCENT_LIGHT_BLUE, 1),
            new EmptyBorder(40, 50, 40, 50)
        ));
        
        GridBagConstraints cardGBC = new GridBagConstraints();
        cardGBC.insets = new Insets(10, 10, 10, 10);
        cardGBC.fill = GridBagConstraints.HORIZONTAL;
        cardGBC.weightx = 1.0;

        JLabel titleLabel = new JLabel("⚕️ Medical Reminder System");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titleLabel.setForeground(PRIMARY_BLUE);
        cardGBC.gridx = 0;
        cardGBC.gridy = 0;
        cardGBC.gridwidth = 2;
        card.add(titleLabel, cardGBC);
        
        JLabel subtitleLabel = new JLabel("Patient Registration");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        subtitleLabel.setForeground(TEXT_DARK);
        cardGBC.gridy = 1;
        card.add(subtitleLabel, cardGBC);
        
        cardGBC.gridwidth = 1;
        cardGBC.gridy = 2;
        JLabel nameLabel = createLabel("Full Name:");
        card.add(nameLabel, cardGBC);
        
        cardGBC.gridx = 1;
        JTextField nameField = createTextField();
        card.add(nameField, cardGBC);
        
        cardGBC.gridx = 0;
        cardGBC.gridy = 3;
        JLabel ageLabel = createLabel("Age:");
        card.add(ageLabel, cardGBC);
        
        cardGBC.gridx = 1;
        JTextField ageField = createTextField();
        card.add(ageField, cardGBC);
        
        cardGBC.gridx = 0;
        cardGBC.gridy = 4;
        JLabel genderLabel = createLabel("Gender:");
        card.add(genderLabel, cardGBC);
        
        cardGBC.gridx = 1;
        JComboBox<String> genderCombo = new JComboBox<>(new String[]{"Male", "Female"});
        genderCombo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        genderCombo.setPreferredSize(new Dimension(200, 35));
        card.add(genderCombo, cardGBC);
        
        cardGBC.gridx = 0;
        cardGBC.gridy = 5;
        cardGBC.gridwidth = 2;
        cardGBC.insets = new Insets(20, 10, 10, 10); // More space above button
        JButton registerButton = createPrimaryButton("Register & Continue");
        registerButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String ageText = ageField.getText().trim();
            
            if (name.isEmpty() || ageText.isEmpty()) {
                showError("Please fill in all fields");
                return;
            }
            
            try {
                int age = Integer.parseInt(ageText);
                if (age <= 0) {
                    showError("Age must be a positive number");
                    return;
                }
                String gender = (String) genderCombo.getSelectedItem();
                currentPatient = new Patient(name, age, gender);
                showMainInterface();
            } catch (NumberFormatException ex) {
                showError("Please enter a valid age");
            }
        });
        card.add(registerButton, cardGBC);
        
        // Add the central card to the main registration panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        registrationPanel.add(card, gbc);
        
        add(registrationPanel);
        setVisible(true);
    }
    
    private void showMainInterface() {
        getContentPane().removeAll();
        setLayout(new BorderLayout());
        
        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, BorderLayout.NORTH);
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(BACKGROUND_GRAY);
        
        dashboardPanel = createDashboardPanel();
        schedulePanel = createViewSchedulePanel();
        markDosePanel = createMarkDosePanel();
        statusPanel = createManageStatusPanel();
        calculatePanel = createCalculateUsagePanel();
        detailsPanel = createViewDetailsPanel();
        
        mainPanel.add(dashboardPanel, "dashboard");
        mainPanel.add(createAddPrescriptionPanel(), "add");
        mainPanel.add(schedulePanel, "schedule");
        mainPanel.add(markDosePanel, "mark");
        mainPanel.add(statusPanel, "status");
        mainPanel.add(calculatePanel, "calculate");
        mainPanel.add(detailsPanel, "details");
        
        add(mainPanel, BorderLayout.CENTER);
        
        JPanel sidePanel = createSidePanel();
        add(sidePanel, BorderLayout.WEST);
        
        revalidate();
        repaint();
    }
    
    private void refreshAllPanels() {
        // This method is critical for updating data. Instead of removing the whole panel,
        // we recreate the panels that require data refresh to avoid UI glitches.
        // We assume the existing cardLayout and mainPanel remain.
        
        // Remove old panels from the mainPanel
        mainPanel.removeAll();
        
        // Recreate all panels
        dashboardPanel = createDashboardPanel();
        schedulePanel = createViewSchedulePanel();
        markDosePanel = createMarkDosePanel();
        statusPanel = createManageStatusPanel();
        calculatePanel = createCalculateUsagePanel();
        detailsPanel = createViewDetailsPanel();
        
        // Re-add them to mainPanel with their card names
        mainPanel.add(dashboardPanel, "dashboard");
        mainPanel.add(createAddPrescriptionPanel(), "add"); // Add always needs a fresh state
        mainPanel.add(schedulePanel, "schedule");
        mainPanel.add(markDosePanel, "mark");
        mainPanel.add(statusPanel, "status");
        mainPanel.add(calculatePanel, "calculate");
        mainPanel.add(detailsPanel, "details");

        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(PRIMARY_BLUE);
        header.setBorder(new EmptyBorder(15, 20, 15, 20));
        
        JLabel titleLabel = new JLabel("Medical Reminder System");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(WHITE);
        
        JLabel patientLabel = new JLabel(currentPatient.getFullName() + " | Age: " + 
                                        currentPatient.getAge() + " | " + currentPatient.getGender());
        patientLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        patientLabel.setForeground(WHITE);
        
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        leftPanel.setOpaque(false);
        leftPanel.add(titleLabel);
        leftPanel.add(new JSeparator(SwingConstants.VERTICAL)); // Visual separator
        leftPanel.add(patientLabel);
        
        header.add(leftPanel, BorderLayout.WEST);
        
        // Add current time display
        JLabel timeLabel = new JLabel(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEE, dd MMM yyyy, HH:mm")));
        timeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        timeLabel.setForeground(WHITE);
        header.add(timeLabel, BorderLayout.EAST);
        
        return header;
    }
    
    private JPanel createSidePanel() {
        JPanel side = new JPanel();
        side.setLayout(new BoxLayout(side, BoxLayout.Y_AXIS));
        side.setBackground(WHITE);
        // Use a softer line color for the border
        side.setBorder(new MatteBorder(0, 0, 0, 1, ACCENT_LIGHT_BLUE)); 
        side.setPreferredSize(new Dimension(240, 0)); // Wider side panel
        
        side.add(Box.createVerticalStrut(30));
        
        addMenuButton(side, "🏠 Dashboard", "dashboard");
        addMenuButton(side, "➕ Add Prescription", "add");
        addMenuButton(side, "🗓️ View Schedule", "schedule");
        addMenuButton(side, "✔️ Mark Dose Taken", "mark");
        addMenuButton(side, "⚙️ Manage Status", "status");
        addMenuButton(side, "🧮 Calculate Usage", "calculate");
        addMenuButton(side, "📋 View Details", "details");
        
        side.add(Box.createVerticalGlue());
        
        JButton exitButton = createSecondaryButton("Exit Application");
        exitButton.setPreferredSize(new Dimension(200, 40));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(e -> System.exit(0));
        side.add(exitButton);
        side.add(Box.createVerticalStrut(30));
        
        return side;
    }
    
    private void addMenuButton(JPanel panel, String text, String cardName) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 15)); // Bolder menu text
        button.setForeground(TEXT_DARK);
        button.setBackground(WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        // Enforce fixed size and alignment
        button.setMaximumSize(MENU_BUTTON_SIZE); 
        button.setPreferredSize(MENU_BUTTON_SIZE);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setBorder(new EmptyBorder(10, 20, 10, 20)); // Padding for readability
        
        button.addActionListener(e -> {
            refreshAllPanels();
            cardLayout.show(mainPanel, cardName);
        });
        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(ACCENT_LIGHT_BLUE);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(WHITE);
            }
        });
        
        panel.add(button);
        panel.add(Box.createVerticalStrut(2)); // Less vertical space
    }
    
    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new BorderLayout(25, 25));
        panel.setBackground(BACKGROUND_GRAY);
        panel.setBorder(new EmptyBorder(30, 30, 30, 30));
        
        JLabel titleLabel = new JLabel("📊 Health Overview");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(TEXT_DARK);
        panel.add(titleLabel, BorderLayout.NORTH);
        
        JPanel statsPanel = new JPanel(new GridLayout(1, 3, 25, 25));
        statsPanel.setOpaque(false);
        
        // Use a mix of colors for visual hierarchy
        statsPanel.add(createStatCard("Total Prescriptions", String.valueOf(prescriptionList.size()), PRIMARY_BLUE));
        statsPanel.add(createStatCard("Currently Active", String.valueOf(getActiveCount()), ACCENT_GREEN));
        statsPanel.add(createStatCard("Completed Treatments", String.valueOf(getCompletedCount()), TEXT_DARK));
        
        panel.add(statsPanel, BorderLayout.CENTER);
        
        // Added a simple placeholder for next action
        JLabel nextActionLabel = new JLabel("Your next scheduled dose is: " + getNextDoseSummary());
        nextActionLabel.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        nextActionLabel.setForeground(ACCENT_ORANGE);
        nextActionLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
        
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setOpaque(false);
        southPanel.add(nextActionLabel, BorderLayout.WEST);
        
        panel.add(southPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private String getNextDoseSummary() {
        List<Medicine> active = getActiveMedicines();
        if (active.isEmpty()) {
            return "None. Enjoy your day!";
        }
        Medicine next = active.get(0);
        return next.getName() + " (" + next.getDosage() + ") at " + 
               next.getNextTakeTime().format(Medicine.FORMATTER);
    }
    
    private JPanel createStatCard(String label, String value, Color color) {
        JPanel card = new JPanel(new BorderLayout(10, 10));
        card.setBackground(WHITE);
        card.setBorder(new CompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 5, 0, color), // Bold bottom border
            new EmptyBorder(25, 25, 25, 25)
        ));
        
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 56));
        valueLabel.setForeground(color);
        valueLabel.setHorizontalAlignment(SwingConstants.LEFT);
        
        JLabel labelLabel = new JLabel(label.toUpperCase());
        labelLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        labelLabel.setForeground(TEXT_DARK);
        labelLabel.setHorizontalAlignment(SwingConstants.LEFT);
        
        card.add(valueLabel, BorderLayout.NORTH);
        card.add(labelLabel, BorderLayout.SOUTH);
        
        return card;
    }
    
    private JPanel createAddPrescriptionPanel() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(BACKGROUND_GRAY);
        panel.setBorder(new EmptyBorder(30, 30, 30, 30));
        
        JLabel titleLabel = new JLabel("📝 Add New Prescription");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(TEXT_DARK);
        panel.add(titleLabel, BorderLayout.NORTH);
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(WHITE);
        formPanel.setBorder(new CompoundBorder(
            new LineBorder(ACCENT_LIGHT_BLUE, 1),
            new EmptyBorder(30, 40, 30, 40) // Increased padding
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        
        JTextField nameField = createTextField();
        JTextField dosageField = createTextField();
        JTextField frequencyField = createTextField();
        JTextField notesField = createTextField();
        JTextField dateField = createTextField();
        dateField.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        JTextField timeField = createTextField();
        timeField.setText("08:00");
        JTextField durationField = createTextField();
        durationField.setText("0");
        
        String[] types = {"Oral Medicine", "Tablet", "Capsule"};
        JComboBox<String> typeCombo = new JComboBox<>(types);
        typeCombo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        typeCombo.setPreferredSize(new Dimension(200, 35));
        
        int row = 0;
        addFormField(formPanel, gbc, row++, "Medicine Name (e.g., Aspirin):", nameField);
        addFormField(formPanel, gbc, row++, "Dosage (e.g., 500mg, 1 tablet):", dosageField);
        addFormField(formPanel, gbc, row++, "Frequency (e.g., 8 hours):", frequencyField);
        addFormField(formPanel, gbc, row++, "Notes (Optional):", notesField);
        addFormField(formPanel, gbc, row++, "Start Date (DD/MM/YYYY):", dateField);
        addFormField(formPanel, gbc, row++, "First Dose Time (HH:MM):", timeField);
        addFormField(formPanel, gbc, row++, "Treatment Duration (days, 0=continuous):", durationField);
        addFormField(formPanel, gbc, row++, "Medicine Type:", typeCombo);
        
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(25, 15, 10, 15);
        JButton addButton = createPrimaryButton("Add Prescription");
        addButton.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                String dosage = dosageField.getText().trim();
                String frequency = frequencyField.getText().trim();
                String notes = notesField.getText().trim();
                String dateStr = dateField.getText().trim() + " " + timeField.getText().trim();
                long duration = Long.parseLong(durationField.getText().trim());
                
                if (name.isEmpty() || dosage.isEmpty() || frequency.isEmpty()) {
                    showError("Please fill in required fields");
                    return;
                }
                
                LocalDateTime initialTime = LocalDateTime.parse(dateStr, 
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                
                String type = (String) typeCombo.getSelectedItem();
                Medicine med;
                if (type.equals("Tablet")) {
                    med = new Tablet(name, dosage, frequency, initialTime, duration);
                } else if (type.equals("Capsule")) {
                    med = new Capsule(name, dosage, frequency, initialTime, duration);
                } else {
                    med = new OralMedicine(name, dosage, frequency, initialTime, duration);
                }
                
                med.setNotes(notes);
                prescriptionList.add(med);
                
                showSuccess("Prescription added successfully!\nNext dose: " + 
                           med.getNextTakeTime().format(Medicine.FORMATTER));
                
                nameField.setText("");
                dosageField.setText("");
                frequencyField.setText("");
                notesField.setText("");
                durationField.setText("0");
                
                refreshAllPanels();
                cardLayout.show(mainPanel, "schedule");
                
            } catch (Exception ex) {
                showError("Error: Please check date/time/frequency format. Example: 8 hours, 01/01/2026 10:30. Details: " + ex.getMessage());
            }
        });
        formPanel.add(addButton, gbc);
        
        panel.add(formPanel, BorderLayout.CENTER);
        return panel;
    }
    
    private JPanel createViewSchedulePanel() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(BACKGROUND_GRAY);
        panel.setBorder(new EmptyBorder(30, 30, 30, 30));
        
        JLabel titleLabel = new JLabel("🗓️ Dose Schedule");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(TEXT_DARK);
        panel.add(titleLabel, BorderLayout.NORTH);
        
        String[] columns = {"Name", "Dosage", "Next Dose", "Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JTable table = new JTable(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        table.setRowHeight(40);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        table.getTableHeader().setBackground(PRIMARY_BLUE);
        table.getTableHeader().setForeground(WHITE);
        table.setSelectionBackground(ACCENT_LIGHT_BLUE);
        table.setSelectionForeground(TEXT_DARK);
        
        // Custom Renderer for visual status
        table.setDefaultRenderer(Object.class, new CustomRenderer());
        
        // Align all columns to center/left
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer()); // Left align Name
        table.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer()); // Left align Dosage
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer); 
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer); 
        
        updateScheduleTable(model);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new LineBorder(PRIMARY_BLUE, 1));
        
        panel.add(scrollPane, BorderLayout.CENTER);
        
        if (prescriptionList.isEmpty()) {
            JLabel emptyLabel = new JLabel("No prescriptions yet. Use 'Add Prescription' to get started.");
            emptyLabel.setFont(new Font("Segoe UI", Font.ITALIC, 18));
            emptyLabel.setForeground(PRIMARY_BLUE);
            emptyLabel.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(emptyLabel, BorderLayout.SOUTH);
        }
        
        return panel;
    }
    
    // Custom Table Cell Renderer for visual status
    private class CustomRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            // Get the Medicine object associated with this row (assuming same order as the model)
            List<Medicine> sorted = new ArrayList<>(prescriptionList);
            sorted.sort(Comparator.comparing(Medicine::getIsCompleted)
                                  .thenComparing(Medicine::getIsActive, Comparator.reverseOrder())
                                  .thenComparing(Medicine::getNextTakeTime));
            
            if (row < sorted.size()) {
                Medicine med = sorted.get(row);
                
                c.setForeground(TEXT_DARK);
                c.setBackground(isSelected ? ACCENT_LIGHT_BLUE : WHITE);
                
                // Status column logic
                if (column == 3) { 
                    String status = med.getStatusDisplay();
                    switch (status) {
                        case "COMPLETED":
                            c.setBackground(new Color(223, 230, 233)); // Light gray completed
                            c.setForeground(TEXT_DARK);
                            break;
                        case "OVERDUE":
                            c.setBackground(new Color(255, 230, 230)); // Light red for overdue
                            c.setForeground(PRIMARY_RED);
                            break;
                        case "ACTIVE":
                            c.setBackground(isSelected ? ACCENT_LIGHT_BLUE : new Color(235, 255, 235)); // Very light green
                            c.setForeground(ACCENT_GREEN);
                            break;
                        case "INACTIVE":
                            c.setBackground(new Color(248, 248, 248));
                            c.setForeground(new Color(150, 150, 150));
                            break;
                    }
                } else if (!isSelected) {
                    c.setBackground(WHITE); // Reset background for other columns
                }
            }
            return c;
        }
    }
    
    private void updateScheduleTable(DefaultTableModel model) {
        model.setRowCount(0);
        List<Medicine> sorted = new ArrayList<>(prescriptionList);
        sorted.sort(Comparator.comparing(Medicine::getIsCompleted)
                              .thenComparing(Medicine::getIsActive, Comparator.reverseOrder())
                              .thenComparing(Medicine::getNextTakeTime));
        
        for (Medicine med : sorted) {
            model.addRow(new Object[]{
                med.getName(),
                med.getDosage(),
                med.getNextTakeTime().format(Medicine.FORMATTER),
                med.getStatusDisplay()
            });
        }
    }
    
    private JPanel createMarkDosePanel() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(BACKGROUND_GRAY);
        panel.setBorder(new EmptyBorder(30, 30, 30, 30));
        
        JLabel titleLabel = new JLabel("✔️ Mark Dose Taken");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(TEXT_DARK);
        panel.add(titleLabel, BorderLayout.NORTH);
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> medList = new JList<>(listModel);
        medList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        medList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        medList.setBackground(WHITE);
        medList.setFixedCellHeight(50); // Larger list items
        
        updateMarkDoseList(listModel);
        
        JScrollPane scrollPane = new JScrollPane(medList);
        scrollPane.setBorder(new LineBorder(PRIMARY_BLUE, 1));
        
        JButton markButton = createPrimaryButton("Mark as Taken & Calculate Next");
        markButton.addActionListener(e -> {
            int index = medList.getSelectedIndex();
            if (index == -1) {
                showError("Please select a prescription");
                return;
            }
            
            List<Medicine> active = getActiveMedicines();
            if (index < active.size()) {
                Medicine med = active.get(index);
                med.take();
                med.calculateNextTime();
                showSuccess("Dose marked as taken!\nNext dose: " + 
                            med.getNextTakeTime().format(Medicine.FORMATTER));
                
                refreshAllPanels();
                cardLayout.show(mainPanel, "mark");
            }
        });
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setOpaque(false);
        buttonPanel.add(markButton);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        if (getActiveMedicines().isEmpty()) {
            JLabel emptyLabel = new JLabel("No active prescriptions available to mark.");
            emptyLabel.setFont(new Font("Segoe UI", Font.ITALIC, 18));
            emptyLabel.setForeground(PRIMARY_BLUE);
            emptyLabel.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(emptyLabel, BorderLayout.CENTER);
        }
        
        return panel;
    }
    
    private void updateMarkDoseList(DefaultListModel<String> model) {
        model.clear();
        List<Medicine> active = getActiveMedicines();
        for (Medicine med : active) {
            model.addElement("<html><b>" + med.getName() + "</b> - " + med.getDosage() + 
                            " <br/>[Next: " + med.getNextTakeTime().format(Medicine.FORMATTER) + "]</html>");
        }
    }
    
    private JPanel createManageStatusPanel() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(BACKGROUND_GRAY);
        panel.setBorder(new EmptyBorder(30, 30, 30, 30));
        
        JLabel titleLabel = new JLabel("⚙️ Manage Prescription Status");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(TEXT_DARK);
        panel.add(titleLabel, BorderLayout.NORTH);
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> medList = new JList<>(listModel);
        medList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        medList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        medList.setBackground(WHITE);
        medList.setFixedCellHeight(50);
        
        updateStatusList(listModel);
        
        JScrollPane scrollPane = new JScrollPane(medList);
        scrollPane.setBorder(new LineBorder(PRIMARY_BLUE, 1));
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15)); // More spacing
        buttonPanel.setOpaque(false);
        
        JButton activeButton = createSecondaryButton("Set Active");
        activeButton.addActionListener(e -> {
            updateStatus(medList, listModel, true, false);
        });
        
        JButton inactiveButton = createSecondaryButton("Set Inactive");
        inactiveButton.addActionListener(e -> {
            updateStatus(medList, listModel, false, false);
        });
        
        JButton completeButton = createSecondaryButton("Set Completed");
        completeButton.addActionListener(e -> {
            updateStatus(medList, listModel, false, true);
        });
        
        JButton deleteButton = createDangerButton("Delete Prescription");
        deleteButton.addActionListener(e -> {
            deleteMedicine(medList, listModel);
        });
        
        buttonPanel.add(activeButton);
        buttonPanel.add(inactiveButton);
        buttonPanel.add(completeButton);
        buttonPanel.add(deleteButton);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        if (prescriptionList.isEmpty()) {
            JLabel emptyLabel = new JLabel("No prescriptions to manage.");
            emptyLabel.setFont(new Font("Segoe UI", Font.ITALIC, 18));
            emptyLabel.setForeground(PRIMARY_BLUE);
            emptyLabel.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(emptyLabel, BorderLayout.CENTER);
        }
        
        return panel;
    }
    
    private void updateStatus(JList<String> list, DefaultListModel<String> model, 
                            boolean active, boolean completed) {
        int index = list.getSelectedIndex();
        if (index == -1) {
            showError("Please select a prescription");
            return;
        }
        
        if (index < prescriptionList.size()) {
            Medicine med = prescriptionList.get(index);
            if (completed) {
                med.setIsCompleted(true);
                showSuccess("Status updated to COMPLETED: " + med.getName());
            } else {
                med.setIsActive(active);
                showSuccess("Status updated to " + (active ? "ACTIVE" : "INACTIVE") + ": " + med.getName());
            }
            
            refreshAllPanels();
            cardLayout.show(mainPanel, "status");
        }
    }
    
    private void deleteMedicine(JList<String> list, DefaultListModel<String> model) {
        int index = list.getSelectedIndex();
        if (index == -1) {
            showError("Please select a prescription");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this prescription? This action cannot be undone.",
            "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION && index < prescriptionList.size()) {
            String medName = prescriptionList.get(index).getName();
            prescriptionList.remove(index);
            showSuccess("Prescription '" + medName + "' deleted successfully");
            
            refreshAllPanels();
            cardLayout.show(mainPanel, "status");
        }
    }
    
    private void updateStatusList(DefaultListModel<String> model) {
        model.clear();
        for (Medicine med : prescriptionList) {
            // Use HTML for richer list item display
            String statusColor = switch (med.getStatusDisplay()) {
                case "COMPLETED" -> "#95A5A6";
                case "OVERDUE" -> "#E74C3C";
                case "ACTIVE" -> "#2ECC71";
                default -> "#3498DB";
            };
            model.addElement("<html><b>" + med.getName() + "</b> (" + med.getDosage() + ") <font color=\"" + statusColor + "\">[" + med.getStatusDisplay() + "]</font></html>");
        }
    }
    
    private JPanel createCalculateUsagePanel() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(BACKGROUND_GRAY);
        panel.setBorder(new EmptyBorder(30, 30, 30, 30));
        
        JLabel titleLabel = new JLabel("🧮 Calculate Medicine Usage");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(TEXT_DARK);
        panel.add(titleLabel, BorderLayout.NORTH);
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(WHITE);
        formPanel.setBorder(new CompoundBorder(
            new LineBorder(ACCENT_LIGHT_BLUE, 1),
            new EmptyBorder(30, 40, 30, 40)
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        
        JComboBox<String> medCombo = new JComboBox<>();
        for (Medicine med : prescriptionList) {
            medCombo.addItem(med.getName() + " (" + med.getDosage() + ")");
        }
        medCombo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        medCombo.setPreferredSize(new Dimension(200, 35));
        
        JTextField daysField = createTextField();
        JTextArea resultArea = new JTextArea(12, 40); // Larger result area
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Monospaced for tabular-like output
        resultArea.setBackground(BACKGROUND_GRAY);
        resultArea.setForeground(TEXT_DARK);
        resultArea.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        if (prescriptionList.isEmpty()) {
            resultArea.setText("No prescriptions available.\nPlease add a prescription first.");
        }
        
        addFormField(formPanel, gbc, 0, "Select Medicine:", medCombo);
        addFormField(formPanel, gbc, 1, "Days to Calculate (for continuous meds):", daysField);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 15, 10, 15);
        JButton calculateButton = createPrimaryButton("Run Calculation");
        calculateButton.addActionListener(e -> {
            int index = medCombo.getSelectedIndex();
            if (index == -1 || prescriptionList.isEmpty()) {
                showError("No prescription selected");
                return;
            }
            
            try {
                Medicine med = prescriptionList.get(index);
                long duration = med.getTreatmentDurationInDays();
                long inputDays = 0;
                
                if (duration <= 0) {
                    if (daysField.getText().trim().isEmpty()) {
                        showError("Enter number of days for continuous prescription");
                        return;
                    }
                    inputDays = Long.parseLong(daysField.getText().trim());
                    duration = inputDays;
                }
                
                String[] parts = med.getFrequency().split(" ");
                if (parts.length != 2) {
                    showError("Frequency format is incorrect (e.g., 8 hours)");
                    return;
                }
                long freq = Long.parseLong(parts[0]);
                String unit = parts[1].toLowerCase();
                
                long dosesPerDay = calculateDosesPerDay(freq, unit);
                long totalDoses = dosesPerDay * duration;
                
                StringBuilder result = new StringBuilder();
                result.append("  ").append("Medicine Usage Analysis\n");
                result.append("  ").append("════════════════════════════════════════\n\n");
                result.append(String.format("  %-15s %s\n", "Medicine:", med.getName()));
                result.append(String.format("  %-15s %s\n", "Dosage:", med.getDosage()));
                result.append(String.format("  %-15s %s\n", "Frequency:", med.getFrequency()));
                result.append(String.format("  %-15s %d days\n", "Period:", duration));
                result.append(String.format("  %-15s %d doses\n\n", "Doses per Day:", dosesPerDay));
                result.append("  ").append("════════════════════════════════════════\n");
                result.append(String.format("  %-15s %d DOSES\n", "TOTAL NEEDED:", totalDoses));
                
                resultArea.setText(result.toString());
                
            } catch (NumberFormatException ex) {
                showError("Error: Please enter a valid number for days.");
            } catch (Exception ex) {
                showError("An unexpected error occurred: " + ex.getMessage());
            }
        });
        formPanel.add(calculateButton, gbc);
        
        gbc.gridy = 3;
        gbc.insets = new Insets(15, 15, 10, 15);
        formPanel.add(new JScrollPane(resultArea), gbc);
        
        panel.add(formPanel, BorderLayout.CENTER);
        return panel;
    }
    
    private long calculateDosesPerDay(long frequency, String unit) {
        if (frequency <= 0) return 0;
        
        if (unit.contains("hour") || unit.contains("hr")) {
            return 24 / frequency;
        } else if (unit.contains("day") || unit.equals("d")) {
            return (frequency == 1) ? 1 : 0;
        } else if (unit.contains("minute") || unit.contains("min")) {
            return (24 * 60) / frequency;
        }
        return 0;
    }
    
    private JPanel createViewDetailsPanel() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(BACKGROUND_GRAY);
        panel.setBorder(new EmptyBorder(30, 30, 30, 30));
        
        JLabel titleLabel = new JLabel("📋 Prescription Details");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(TEXT_DARK);
        panel.add(titleLabel, BorderLayout.NORTH);
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> medList = new JList<>(listModel);
        medList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        medList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        medList.setBackground(WHITE);
        medList.setFixedCellHeight(40);
        
        JScrollPane listScroll = new JScrollPane(medList);
        listScroll.setBorder(new LineBorder(PRIMARY_BLUE, 1));
        listScroll.setPreferredSize(new Dimension(350, 0)); // Wider list column
        
        JTextArea detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        detailsArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        detailsArea.setBackground(WHITE);
        detailsArea.setForeground(TEXT_DARK);
        detailsArea.setBorder(new EmptyBorder(25, 25, 25, 25)); // More padding
        
        JScrollPane detailsScroll = new JScrollPane(detailsArea);
        detailsScroll.setBorder(new LineBorder(PRIMARY_BLUE, 1));
        
        medList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int index = medList.getSelectedIndex();
                if (index >= 0 && index < prescriptionList.size()) {
                    displayMedicineDetails(prescriptionList.get(index), detailsArea);
                } else {
                    detailsArea.setText("");
                }
            }
        });
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
                                               listScroll, detailsScroll);
        splitPane.setDividerLocation(350);
        splitPane.setOpaque(false);
        splitPane.setDividerSize(10);
        
        panel.add(splitPane, BorderLayout.CENTER);
        
        updateDetailsList(listModel);
        
        return panel;
    }
    
    private void displayMedicineDetails(Medicine med, JTextArea area) {
        StringBuilder sb = new StringBuilder();
        sb.append("════════════════════════════════════════\n");
        sb.append("   MEDICINE: ").append(med.getName().toUpperCase()).append("\n");
        sb.append("   TYPE: ").append(med.toString()).append("\n");
        sb.append("════════════════════════════════════════\n\n");
        sb.append(String.format("  %-15s %s\n", "Dosage:", med.getDosage()));
        sb.append(String.format("  %-15s %s\n", "Frequency:", med.getFrequency()));
        sb.append(String.format("  %-15s %s\n", "Next Dose:", med.getNextTakeTime().format(Medicine.FORMATTER)));
        sb.append(String.format("  %-15s %s\n\n", "Current Status:", med.getStatusDisplay()));
        
        if (!med.getNotes().isEmpty()) {
            sb.append("  NOTES:\n");
            sb.append("  - ").append(med.getNotes()).append("\n\n");
        }
        
        sb.append("  TREATING PERIOD\n");
        sb.append("  ---------------------------------------\n");
        
        if (med.getTreatmentDurationInDays() > 0) {
            LocalDate today = LocalDate.now();
            LocalDate endDate = med.getStartDate().plusDays(med.getTreatmentDurationInDays() - 1);
            long daysRemaining = ChronoUnit.DAYS.between(today, endDate) + 1;
            
            sb.append(String.format("  %-15s %s\n", "Start Date:", med.getStartDate().format(Medicine.getDateFormatter())));
            sb.append(String.format("  %-15s %d days\n", "Duration:", med.getTreatmentDurationInDays()));
            
            if (daysRemaining > 0) {
                sb.append(String.format("  %-15s %d days\n", "Days Remaining:", daysRemaining));
            } else {
                sb.append("  Treatment period ended: ").append(endDate.format(Medicine.getDateFormatter())).append("\n");
            }
        } else {
            sb.append(String.format("  %-15s Continuous\n", "Duration:"));
        }
        
        sb.append("\n════════════════════════════════════════");
        area.setText(sb.toString());
    }
    
    private void updateDetailsList(DefaultListModel<String> model) {
        model.clear();
        for (Medicine med : prescriptionList) {
            // Use HTML for richer list item display
            String statusColor = switch (med.getStatusDisplay()) {
                case "COMPLETED" -> "#95A5A6";
                case "OVERDUE" -> "#E74C3C";
                case "ACTIVE" -> "#2ECC71";
                default -> "#3498DB";
            };
            model.addElement("<html><b>" + med.getName() + "</b> <font color=\"" + statusColor + "\">[" + med.getStatusDisplay() + "]</font></html>");
        }
    }
    
    private void addFormField(JPanel panel, GridBagConstraints gbc, int row, 
                             String label, JComponent field) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        JLabel jLabel = createLabel(label);
        panel.add(jLabel, gbc);
        
        gbc.gridx = 1;
        panel.add(field, gbc);
    }
    
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 16)); // Bolder labels for forms
        label.setForeground(TEXT_DARK);
        return label;
    }
    
    private JTextField createTextField() {
        JTextField field = new JTextField(25);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        field.setBorder(new CompoundBorder(
            new LineBorder(ACCENT_LIGHT_BLUE, 1),
            new EmptyBorder(8, 12, 8, 12) // Increased padding inside field
        ));
        field.setPreferredSize(new Dimension(200, 35));
        return field;
    }
    
    // Adjusted button styles
    private JButton createPrimaryButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setForeground(WHITE);
        button.setBackground(PRIMARY_BLUE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(250, 45)); // Larger button
        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(ACCENT_DARK_BLUE);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(PRIMARY_BLUE);
            }
        });
        
        return button;
    }
    
    private JButton createSecondaryButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 15));
        button.setForeground(PRIMARY_BLUE);
        button.setBackground(WHITE);
        button.setBorder(new LineBorder(PRIMARY_BLUE, 2));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(160, 40));
        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(ACCENT_LIGHT_BLUE);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(WHITE);
            }
        });
        
        return button;
    }
    
    private JButton createDangerButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 15));
        button.setForeground(WHITE);
        button.setBackground(PRIMARY_RED); // Use the original RED for danger/delete
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(180, 40));
        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(180, 40, 55));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(PRIMARY_RED);
            }
        });
        
        return button;
    }
    
    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Input Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void showSuccess(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private List<Medicine> getActiveMedicines() {
        List<Medicine> active = new ArrayList<>();
        for (Medicine med : prescriptionList) {
            if (med.getIsActive() && !med.getIsCompleted() && !med.isDurationExceeded()) {
                active.add(med);
            }
        }
        active.sort(Comparator.comparing(Medicine::getNextTakeTime));
        return active;
    }
    
    private int getActiveCount() {
        return (int) prescriptionList.stream()
            .filter(m -> m.getIsActive() && !m.getIsCompleted() && !m.isDurationExceeded())
            .count();
    }
    
    private int getCompletedCount() {
        return (int) prescriptionList.stream()
            .filter(Medicine::getIsCompleted)
            .count();
    }
    
    public static void main(String[] args) {
        // Set a look and feel for a more modern appearance
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            // Fallback to default L&F
        }
        SwingUtilities.invokeLater(() -> new MedicalGUI());
    }
}

// --- Auxiliary Classes (No changes needed, but included for completeness) ---

abstract class Medicine {
    private String name;
    private String dosage;
    private String frequency;
    private LocalDateTime nextTakeTime;
    private LocalDate startDate;
    private long treatmentDurationInDays;
    private String notes;
    private boolean isCompleted = false;
    private boolean isActive = true;

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Medicine(String name, String dosage, String frequency, LocalDateTime nextTakeTime, long durationDays) {
        this.name = name;
        this.dosage = dosage;
        this.frequency = frequency;
        this.nextTakeTime = nextTakeTime;
        this.startDate = nextTakeTime.toLocalDate();
        this.treatmentDurationInDays = durationDays;
        this.notes = "";
        this.isActive = true;
        this.isCompleted = false;
    }

    public static DateTimeFormatter getDateFormatter() {
        return DATE_FORMATTER;
    }

    public abstract void take();

    public boolean isDurationExceeded() {
        if (treatmentDurationInDays <= 0) return false;
        LocalDate today = LocalDate.now();
        LocalDate endDate = startDate.plusDays(treatmentDurationInDays - 1);
        return today.isAfter(endDate);
    }

    public void calculateNextTime() {
        if (isCompleted) return;
        
        String[] parts = frequency.split(" ");
        if (parts.length != 2) return;

        try {
            long value = Long.parseLong(parts[0]);
            String unit = parts[1].toLowerCase().trim();

            Duration duration = switch (unit) {
                case "hours", "hour", "hr", "hrs" -> Duration.ofHours(value);
                case "days", "day", "d" -> Duration.ofDays(value);
                case "minutes", "minute", "min", "mins" -> Duration.ofMinutes(value);
                default -> null;
            };

            if (duration != null) {
                this.nextTakeTime = this.nextTakeTime.plus(duration);
            }
        } catch (NumberFormatException e) {
        }
    }

    public void setIsCompleted(boolean completed) {
        this.isCompleted = completed;
        if (completed) this.isActive = false;
    }

    public void setIsActive(boolean active) {
        this.isActive = active;
        if (active) this.isCompleted = false;
    }

    public String getName() { return name; }
    public String getDosage() { return dosage; }
    public String getFrequency() { return frequency; }
    public LocalDateTime getNextTakeTime() { return nextTakeTime; }
    public long getTreatmentDurationInDays() { return treatmentDurationInDays; }
    public boolean getIsCompleted() { return isCompleted; }
    public boolean getIsActive() { return isActive; }
    public LocalDate getStartDate() { return startDate; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getStatusDisplay() {
        if (isCompleted) return "COMPLETED";
        if (!isActive) return "INACTIVE";
        if (treatmentDurationInDays > 0 && isDurationExceeded()) return "OVERDUE";
        return "ACTIVE";
    }
}

class OralMedicine extends Medicine {
    public OralMedicine(String name, String dosage, String frequency, LocalDateTime nextTakeTime, long durationDays) {
        super(name, dosage, frequency, nextTakeTime, durationDays);
    }
    
    public void take() {
    }
    
    public String toString() {
        return "Oral Medicine";
    }
}

class Tablet extends Medicine {
    public Tablet(String name, String dosage, String frequency, LocalDateTime nextTakeTime, long durationDays) {
        super(name, dosage, frequency, nextTakeTime, durationDays);
    }
    
    public void take() {
    }
    
    public String toString() {
        return "Tablet";
    }
}

class Capsule extends Medicine {
    public Capsule(String name, String dosage, String frequency, LocalDateTime nextTakeTime, long durationDays) {
        super(name, dosage, frequency, nextTakeTime, durationDays);
    }
    
    public void take() {
    }
    
    public String toString() {
        return "Capsule";
    }
}

class Patient {
    private String patientID;
    private String fullName;
    private int age;
    private String gender;
    private LocalDate recordedDate;

    public Patient(String fullName, int age, String gender) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.recordedDate = LocalDate.now();
        this.patientID = "PAT" + System.currentTimeMillis() % 100000;
    }

    public String getFullName() { return fullName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getPatientID() { return patientID; }
}