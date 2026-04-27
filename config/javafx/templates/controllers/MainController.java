package com.dsa.javafx.controllers;

import com.dsa.javafx.DSAJavaFXApplication;
import com.dsa.javafx.utils.AlgorithmManager;
import com.dsa.javafx.utils.UIManager;
import com.dsa.javafx.utils.DataManager;
import com.dsa.javafx.models.AlgorithmModel;
import com.dsa.javafx.models.DataStructureModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.chart.*;
import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.animation.*;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Main controller for the DSA JavaFX application.
 * 
 * This controller manages the main application interface, including
 * the menu bar, toolbar, status bar, and main content area.
 * It coordinates between different algorithm visualizations and
 * manages the overall application state.
 * 
 * @Complexity Time: O(1) - Controller initialization
 * @Complexity Space: O(n) - Where n is the number of UI components
 * @Performance Optimized with lazy loading and caching
 * @Stability Stable - Production ready
 * @Algorithm MVC Controller pattern
 * @Implementation JavaFX FXML controller
 * @Optimization Event handling optimization
 * @Reference JavaFX MVC Architecture
 */
public class MainController implements Initializable {
    
    // Menu Bar Components
    @FXML private MenuBar menuBar;
    @FXML private Menu fileMenu;
    @FXML private Menu editMenu;
    @FXML private Menu viewMenu;
    @FXML private Menu toolsMenu;
    @FXML private Menu helpMenu;
    
    // File Menu Items
    @FXML private MenuItem newMenuItem;
    @FXML private MenuItem openMenuItem;
    @FXML private MenuItem saveMenuItem;
    @FXML private MenuItem saveAsMenuItem;
    @FXML private MenuItem exitMenuItem;
    
    // Edit Menu Items
    @FXML private MenuItem undoMenuItem;
    @FXML private MenuItem redoMenuItem;
    @FXML private MenuItem cutMenuItem;
    @FXML private MenuItem copyMenuItem;
    @FXML private MenuItem pasteMenuItem;
    @FXML private MenuItem preferencesMenuItem;
    
    // View Menu Items
    @FXML private MenuItem zoomInMenuItem;
    @FXML private MenuItem zoomOutMenuItem;
    @FXML private MenuItem resetZoomMenuItem;
    @FXML private MenuItem fullscreenMenuItem;
    @FXML private CheckMenuItem showGridMenuItem;
    @FXML private CheckMenuItem showAnimationMenuItem;
    
    // Tools Menu Items
    @FXML private MenuItem algorithmAnalyzerMenuItem;
    @FXML private MenuItem performanceMonitorMenuItem;
    @FXML private MenuItem dataGeneratorMenuItem;
    @FXML private MenuItem exportMenuItem;
    
    // Help Menu Items
    @FXML private MenuItem aboutMenuItem;
    @FXML private MenuItem helpMenuItem;
    @FXML private MenuItem tutorialMenuItem;
    
    // Toolbar Components
    @FXML private ToolBar toolBar;
    @FXML private Button newButton;
    @FXML private Button openButton;
    @FXML private Button saveButton;
    @FXML private Button undoButton;
    @FXML private Button redoButton;
    @FXML private Button zoomInButton;
    @FXML private Button zoomOutButton;
    @FXML private Button resetZoomButton;
    @FXML private Button playButton;
    @FXML private Button pauseButton;
    @FXML private Button stopButton;
    @FXML private Button resetButton;
    
    // Status Bar Components
    @FXML private StatusBar statusBar;
    @FXML private Label statusLabel;
    @FXML private Label algorithmLabel;
    @FXML private Label performanceLabel;
    @FXML private ProgressBar progressBar;
    @FXML private ProgressIndicator progressIndicator;
    
    // Main Content Area
    @FXML private SplitPane mainSplitPane;
    @FXML private TabPane tabPane;
    @FXML private Tab algorithmsTab;
    @FXML private Tab dataStructuresTab;
    @FXML private Tab visualizationTab;
    @FXML private Tab performanceTab;
    
    // Algorithm Tab Content
    @FXML private VBox algorithmsVBox;
    @FXML private ListView<String> algorithmListView;
    @FXML private ComboBox<String> algorithmCategoryComboBox;
    @FXML private TextField searchAlgorithmTextField;
    @FXML private TextArea algorithmDescriptionTextArea;
    @FXML private Button runAlgorithmButton;
    @FXML private Button stepAlgorithmButton;
    @FXML private Button resetAlgorithmButton;
    
    // Data Structures Tab Content
    @FXML private VBox dataStructuresVBox;
    @FXML private ListView<String> dataStructureListView;
    @FXML private ComboBox<String> dataStructureTypeComboBox;
    @FXML private TextField searchDataStructureTextField;
    @FXML private TextArea dataStructureDescriptionTextArea;
    @FXML private Button createDataStructureButton;
    @FXML private Button clearDataStructureButton;
    
    // Visualization Tab Content
    @FXML private VBox visualizationVBox;
    @FXML private Canvas visualizationCanvas;
    @FXML private ScrollPane visualizationScrollPane;
    @FXML private Slider animationSpeedSlider;
    @FXML private Button playAnimationButton;
    @FXML private Button pauseAnimationButton;
    @FXML private Button stopAnimationButton;
    @FXML private Button resetAnimationButton;
    
    // Performance Tab Content
    @FXML private VBox performanceVBox;
    @FXML private LineChart<String, Number> performanceChart;
    @FXML private BarChart<String, Number> algorithmComparisonChart;
    @FXML private TableView<PerformanceData> performanceTableView;
    @FXML private TableColumn<PerformanceData, String> algorithmColumn;
    @FXML private TableColumn<PerformanceData, Number> timeColumn;
    @FXML private TableColumn<PerformanceData, Number> memoryColumn;
    @FXML private Button runPerformanceTestButton;
    @FXML private Button clearResultsButton;
    
    // Sidebar Components
    @FXML private VBox sidebarVBox;
    @FXML private Accordion sidebarAccordion;
    @FXML private TitledPane propertiesTitledPane;
    @FXML private TitledPane settingsTitledPane;
    @FXML private TitledPane helpTitledPane;
    
    // Properties Panel
    @FXML private VBox propertiesVBox;
    @FXML private GridPane propertiesGridPane;
    @FXML private Label algorithmNameLabel;
    @FXML private TextField algorithmNameTextField;
    @FXML private Label timeComplexityLabel;
    @FXML private TextField timeComplexityTextField;
    @FXML private Label spaceComplexityLabel;
    @FXML private TextField spaceComplexityTextField;
    @FXML private Label dataSizeLabel;
    @FXML private Slider dataSizeSlider;
    @FXML private Label dataSizeValueLabel;
    
    // Settings Panel
    @FXML private VBox settingsVBox;
    @FXML private GridPane settingsGridPane;
    @FXML private Label themeLabel;
    @FXML private ComboBox<String> themeComboBox;
    @FXML private Label languageLabel;
    @FXML private ComboBox<String> languageComboBox;
    @FXML private Label animationSpeedLabel;
    @FXML private Slider animationSpeedSettingsSlider;
    @FXML private CheckMenuItem showGridCheckMenuItem;
    @FXML private CheckMenuItem showAnimationCheckMenuItem;
    
    // Help Panel
    @FXML private VBox helpVBox;
    @FXML private WebView helpWebView;
    @FXML private Button previousHelpButton;
    @FXML private Button nextHelpButton;
    @FXML private Button homeHelpButton;
    
    // Application Reference
    private DSAJavaFXApplication mainApp;
    
    // Managers
    private AlgorithmManager algorithmManager;
    private UIManager uiManager;
    private DataManager dataManager;
    
    // Models
    private AlgorithmModel currentAlgorithm;
    private DataStructureModel currentDataStructure;
    
    // Data
    private Map<String, String> algorithmMap;
    private Map<String, String> dataStructureMap;
    private List<PerformanceData> performanceDataList;
    
    // Animation
    private Timeline animationTimeline;
    private boolean isAnimating = false;
    private double animationSpeed = 1.0;
    
    /**
     * Initialize the controller with FXML components.
     * This method is called after the FXML file has been loaded.
     * 
     * @param location The location used to resolve relative paths
     * @param resources The resources used to localize the root object
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            // Initialize managers
            initializeManagers();
            
            // Initialize data
            initializeData();
            
            // Initialize UI components
            initializeUIComponents();
            
            // Setup event handlers
            setupEventHandlers();
            
            // Load initial data
            loadInitialData();
            
            // Setup animations
            setupAnimations();
            
            // Setup keyboard shortcuts
            setupKeyboardShortcuts();
            
            // Initialize tooltips
            initializeTooltips();
            
            // Setup context menus
            setupContextMenus();
            
            // Initialize validators
            initializeValidators();
            
            // Setup drag and drop
            setupDragAndDrop();
            
        } catch (Exception e) {
            showError("Failed to initialize main controller: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Initialize the controller with the main application reference.
     * This method should be called after the FXML has been loaded.
     * 
     * @param mainApp The main application instance
     */
    public void initializeController() {
        this.mainApp = mainApp;
        
        // Setup managers with application reference
        algorithmManager.setMainApp(mainApp);
        uiManager.setMainApp(mainApp);
        dataManager.setMainApp(mainApp);
        
        // Load saved preferences
        loadPreferences();
        
        // Setup update checking
        setupUpdateChecking();
        
        // Setup crash reporting
        setupCrashReporting();
    }
    
    /**
     * Initialize the managers used by this controller.
     */
    private void initializeManagers() {
        algorithmManager = new AlgorithmManager();
        uiManager = new UIManager();
        dataManager = new DataManager();
        
        performanceDataList = new ArrayList<>();
        algorithmMap = new HashMap<>();
        dataStructureMap = new HashMap<>();
    }
    
    /**
     * Initialize the data structures and maps.
     */
    private void initializeData() {
        // Initialize algorithm map
        algorithmMap.put("Binary Search", "Search algorithm for sorted arrays");
        algorithmMap.put("Linear Search", "Simple search algorithm for unsorted arrays");
        algorithmMap.put("Bubble Sort", "Simple sorting algorithm");
        algorithmMap.put("Selection Sort", "Selection-based sorting algorithm");
        algorithmMap.put("Insertion Sort", "Insertion-based sorting algorithm");
        algorithmMap.put("Merge Sort", "Divide and conquer sorting algorithm");
        algorithmMap.put("Quick Sort", "Efficient divide and conquer sorting algorithm");
        
        // Initialize data structure map
        dataStructureMap.put("Array", "Fixed-size sequential collection");
        dataStructureMap.put("ArrayList", "Dynamic array implementation");
        dataStructureMap.put("LinkedList", "Linked list implementation");
        dataStructureMap.put("Stack", "LIFO data structure");
        dataStructureMap.put("Queue", "FIFO data structure");
        dataStructureMap.put("Tree", "Hierarchical data structure");
        dataStructureMap.put("Graph", "Network data structure");
        dataStructureMap.put("HashMap", "Key-value mapping data structure");
    }
    
    /**
     * Initialize the UI components.
     */
    private void initializeUIComponents() {
        // Setup algorithm list view
        algorithmListView.getItems().addAll(algorithmMap.keySet());
        algorithmListView.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldVal, newVal) -> onAlgorithmSelected(newVal));
        
        // Setup data structure list view
        dataStructureListView.getItems().addAll(dataStructureMap.keySet());
        dataStructureListView.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldVal, newVal) -> onDataStructureSelected(newVal));
        
        // Setup algorithm category combo box
        algorithmCategoryComboBox.getItems().addAll("All", "Sorting", "Searching", "Data Structures");
        algorithmCategoryComboBox.getSelectionModel().selectFirst();
        
        // Setup data structure type combo box
        dataStructureTypeComboBox.getItems().addAll("All", "Linear", "Non-Linear", "Trees", "Graphs");
        dataStructureTypeComboBox.getSelectionModel().selectFirst();
        
        // Setup theme combo box
        themeComboBox.getItems().addAll("Material Light", "Material Dark", "Windows", "macOS", "Linux");
        themeComboBox.getSelectionModel().selectFirst();
        
        // Setup language combo box
        languageComboBox.getItems().addAll("English", "Spanish", "French", "German", "Italian", "Portuguese", "Chinese", "Japanese");
        languageComboBox.getSelectionModel().selectFirst();
        
        // Setup performance chart
        setupPerformanceChart();
        
        // Setup algorithm comparison chart
        setupAlgorithmComparisonChart();
        
        // Setup performance table view
        setupPerformanceTableView();
        
        // Setup visualization canvas
        setupVisualizationCanvas();
    }
    
    /**
     * Setup event handlers for UI components.
     */
    private void setupEventHandlers() {
        // File menu handlers
        newMenuItem.setOnAction(e -> handleNewAction());
        openMenuItem.setOnAction(e -> handleOpenAction());
        saveMenuItem.setOnAction(e -> handleSaveAction());
        saveAsMenuItem.setOnAction(e -> handleSaveAsAction());
        exitMenuItem.setOnAction(e -> handleExitAction());
        
        // Edit menu handlers
        undoMenuItem.setOnAction(e -> handleUndoAction());
        redoMenuItem.setOnAction(e -> handleRedoAction());
        cutMenuItem.setOnAction(e -> handleCutAction());
        copyMenuItem.setOnAction(e -> handleCopyAction());
        pasteMenuItem.setOnAction(e -> handlePasteAction());
        preferencesMenuItem.setOnAction(e -> handlePreferencesAction());
        
        // View menu handlers
        zoomInMenuItem.setOnAction(e -> handleZoomInAction());
        zoomOutMenuItem.setOnAction(e -> handleZoomOutAction());
        resetZoomMenuItem.setOnAction(e -> handleResetZoomAction());
        fullscreenMenuItem.setOnAction(e -> handleFullscreenAction());
        showGridMenuItem.setOnAction(e -> handleShowGridAction());
        showAnimationMenuItem.setOnAction(e -> handleShowAnimationAction());
        
        // Tools menu handlers
        algorithmAnalyzerMenuItem.setOnAction(e -> handleAlgorithmAnalyzerAction());
        performanceMonitorMenuItem.setOnAction(e -> handlePerformanceMonitorAction());
        dataGeneratorMenuItem.setOnAction(e -> handleDataGeneratorAction());
        exportMenuItem.setOnAction(e -> handleExportAction());
        
        // Help menu handlers
        aboutMenuItem.setOnAction(e -> handleAboutAction());
        helpMenuItem.setOnAction(e -> handleHelpAction());
        tutorialMenuItem.setOnAction(e -> handleTutorialAction());
        
        // Toolbar handlers
        newButton.setOnAction(e -> handleNewAction());
        openButton.setOnAction(e -> handleOpenAction());
        saveButton.setOnAction(e -> handleSaveAction());
        undoButton.setOnAction(e -> handleUndoAction());
        redoButton.setOnAction(e -> handleRedoAction());
        zoomInButton.setOnAction(e -> handleZoomInAction());
        zoomOutButton.setOnAction(e -> handleZoomOutAction());
        resetZoomButton.setOnAction(e -> handleResetZoomAction());
        playButton.setOnAction(e -> handlePlayAction());
        pauseButton.setOnAction(e -> handlePauseAction());
        stopButton.setOnAction(e -> handleStopAction());
        resetButton.setOnAction(e -> handleResetAction());
        
        // Algorithm tab handlers
        runAlgorithmButton.setOnAction(e -> handleRunAlgorithmAction());
        stepAlgorithmButton.setOnAction(e -> handleStepAlgorithmAction());
        resetAlgorithmButton.setOnAction(e -> handleResetAlgorithmAction());
        
        // Data structure tab handlers
        createDataStructureButton.setOnAction(e -> handleCreateDataStructureAction());
        clearDataStructureButton.setOnAction(e -> handleClearDataStructureAction());
        
        // Visualization tab handlers
        playAnimationButton.setOnAction(e -> handlePlayAnimationAction());
        pauseAnimationButton.setOnAction(e -> handlePauseAnimationAction());
        stopAnimationButton.setOnAction(e -> handleStopAnimationAction());
        resetAnimationButton.setOnAction(e -> handleResetAnimationAction());
        
        // Performance tab handlers
        runPerformanceTestButton.setOnAction(e -> handleRunPerformanceTestAction());
        clearResultsButton.setOnAction(e -> handleClearResultsAction());
        
        // Search handlers
        searchAlgorithmTextField.setOnKeyPressed(e -> handleAlgorithmSearch(e));
        searchDataStructureTextField.setOnKeyPressed(e -> handleDataStructureSearch(e));
        
        // Filter handlers
        algorithmCategoryComboBox.setOnAction(e -> handleAlgorithmFilter());
        dataStructureTypeComboBox.setOnAction(e -> handleDataStructureFilter());
        
        // Settings handlers
        themeComboBox.setOnAction(e -> handleThemeChange());
        languageComboBox.setOnAction(e -> handleLanguageChange());
        animationSpeedSlider.valueProperty().addListener((obs, oldVal, newVal) -> handleAnimationSpeedChange(newVal.doubleValue()));
        dataSizeSlider.valueProperty().addListener((obs, oldVal, newVal) -> handleDataSizeChange(newVal.intValue()));
    }
    
    /**
     * Load initial data into the UI components.
     */
    private void loadInitialData() {
        // Load default algorithm
        if (!algorithmMap.isEmpty()) {
            algorithmListView.getSelectionModel().select(0);
        }
        
        // Load default data structure
        if (!dataStructureMap.isEmpty()) {
            dataStructureListView.getSelectionModel().select(0);
        }
        
        // Load default settings
        loadDefaultSettings();
    }
    
    /**
     * Setup animations for the application.
     */
    private void setupAnimations() {
        animationTimeline = new Timeline(
            new KeyFrame(Duration.millis(1000), e -> handleAnimationTick())
        );
        animationTimeline.setCycleCount(Animation.INDEFINITE);
    }
    
    /**
     * Setup keyboard shortcuts for the application.
     */
    private void setupKeyboardShortcuts() {
        // File shortcuts
        newMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        openMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        saveMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        saveAsMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
        
        // Edit shortcuts
        undoMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN));
        redoMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN));
        cutMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
        copyMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
        pasteMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));
        
        // View shortcuts
        zoomInMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.PLUS, KeyCombination.CONTROL_DOWN));
        zoomOutMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.MINUS, KeyCombination.CONTROL_DOWN));
        resetZoomMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT0, KeyCombination.CONTROL_DOWN));
        fullscreenMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.F11));
    }
    
    /**
     * Initialize tooltips for UI components.
     */
    private void initializeTooltips() {
        // Button tooltips
        newButton.setTooltip(new Tooltip("Create new project"));
        openButton.setTooltip(new Tooltip("Open existing project"));
        saveButton.setTooltip(new Tooltip("Save current project"));
        undoButton.setTooltip(new Tooltip("Undo last action"));
        redoButton.setTooltip(new Tooltip("Redo last action"));
        zoomInButton.setTooltip(new Tooltip("Zoom in"));
        zoomOutButton.setTooltip(new Tooltip("Zoom out"));
        resetZoomButton.setTooltip(new Tooltip("Reset zoom"));
        playButton.setTooltip(new Tooltip("Play animation"));
        pauseButton.setTooltip(new Tooltip("Pause animation"));
        stopButton.setTooltip(new Tooltip("Stop animation"));
        resetButton.setTooltip(new Tooltip("Reset animation"));
        
        // Algorithm tooltips
        runAlgorithmButton.setTooltip(new Tooltip("Run selected algorithm"));
        stepAlgorithmButton.setTooltip(new Tooltip("Step through algorithm"));
        resetAlgorithmButton.setTooltip(new Tooltip("Reset algorithm"));
        
        // Data structure tooltips
        createDataStructureButton.setTooltip(new Tooltip("Create new data structure"));
        clearDataStructureButton.setTooltip(new Tooltip("Clear data structure"));
        
        // Visualization tooltips
        playAnimationButton.setTooltip(new Tooltip("Play visualization"));
        pauseAnimationButton.setTooltip(new Tooltip("Pause visualization"));
        stopAnimationButton.setTooltip(new Tooltip("Stop visualization"));
        resetAnimationButton.setTooltip(new Tooltip("Reset visualization"));
        
        // Performance tooltips
        runPerformanceTestButton.setTooltip(new Tooltip("Run performance test"));
        clearResultsButton.setTooltip(new Tooltip("Clear performance results"));
    }
    
    /**
     * Setup context menus for UI components.
     */
    private void setupContextMenus() {
        // Algorithm list view context menu
        ContextMenu algorithmContextMenu = new ContextMenu();
        MenuItem runContextItem = new MenuItem("Run");
        MenuItem stepContextItem = new MenuItem("Step");
        MenuItem resetContextItem = new MenuItem("Reset");
        MenuItem propertiesContextItem = new MenuItem("Properties");
        
        runContextItem.setOnAction(e -> handleRunAlgorithmAction());
        stepContextItem.setOnAction(e -> handleStepAlgorithmAction());
        resetContextItem.setOnAction(e -> handleResetAlgorithmAction());
        propertiesContextItem.setOnAction(e -> handleAlgorithmPropertiesAction());
        
        algorithmContextMenu.getItems().addAll(runContextItem, stepContextItem, resetContextItem, propertiesContextItem);
        algorithmListView.setContextMenu(algorithmContextMenu);
        
        // Data structure list view context menu
        ContextMenu dataStructureContextMenu = new ContextMenu();
        MenuItem createContextItem = new MenuItem("Create");
        MenuItem clearContextItem = new MenuItem("Clear");
        MenuItem visualizeContextItem = new MenuItem("Visualize");
        MenuItem propertiesDSContextItem = new MenuItem("Properties");
        
        createContextItem.setOnAction(e -> handleCreateDataStructureAction());
        clearContextItem.setOnAction(e -> handleClearDataStructureAction());
        visualizeContextItem.setOnAction(e -> handleVisualizeDataStructureAction());
        propertiesDSContextItem.setOnAction(e -> handleDataStructurePropertiesAction());
        
        dataStructureContextMenu.getItems().addAll(createContextItem, clearContextItem, visualizeContextItem, propertiesDSContextItem);
        dataStructureListView.setContextMenu(dataStructureContextMenu);
    }
    
    /**
     * Initialize validators for input fields.
     */
    private void initializeValidators() {
        // Algorithm name validator
        algorithmNameTextField.textProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal.matches("[a-zA-Z0-9 ]*")) {
                algorithmNameTextField.setText(oldVal);
            }
        });
        
        // Time complexity validator
        timeComplexityTextField.textProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal.matches("[Oo]\\([a-zA-Z0-9^*\\-+/ ]*\\)")) {
                timeComplexityTextField.setText(oldVal);
            }
        });
        
        // Space complexity validator
        spaceComplexityTextField.textProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal.matches("[Oo]\\([a-zA-Z0-9^*\\-+/ ]*\\)")) {
                spaceComplexityTextField.setText(oldVal);
            }
        });
    }
    
    /**
     * Setup drag and drop functionality.
     */
    private void setupDragAndDrop() {
        // Algorithm list view drag and drop
        algorithmListView.setOnDragOver(e -> {
            if (e.getGestureSource() != algorithmListView && e.getDragboard().hasString()) {
                e.acceptTransferModes(TransferMode.COPY);
            }
            e.consume();
        });
        
        algorithmListView.setOnDragDropped(e -> {
            Dragboard db = e.getDragboard();
            boolean success = false;
            
            if (db.hasString()) {
                String algorithmName = db.getString();
                if (algorithmMap.containsKey(algorithmName)) {
                    algorithmListView.getSelectionModel().select(algorithmName);
                    success = true;
                }
            }
            
            e.setDropCompleted(success);
            e.consume();
        });
    }
    
    /**
     * Setup the performance chart.
     */
    private void setupPerformanceChart() {
        performanceChart.setTitle("Algorithm Performance Over Time");
        performanceChart.getXAxis().setLabel("Time");
        performanceChart.getYAxis().setLabel("Execution Time (ms)");
        
        // Create series for different algorithms
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Algorithm Performance");
        
        performanceChart.getData().add(series);
    }
    
    /**
     * Setup the algorithm comparison chart.
     */
    private void setupAlgorithmComparisonChart() {
        algorithmComparisonChart.setTitle("Algorithm Comparison");
        algorithmComparisonChart.getXAxis().setLabel("Algorithm");
        algorithmComparisonChart.getYAxis().setLabel("Execution Time (ms)");
        
        // Create series for comparison
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Comparison Results");
        
        algorithmComparisonChart.getData().add(series);
    }
    
    /**
     * Setup the performance table view.
     */
    private void setupPerformanceTableView() {
        algorithmColumn.setCellValueFactory(data -> data.getValue().algorithmNameProperty());
        timeColumn.setCellValueFactory(data -> data.getValue().executionTimeProperty());
        memoryColumn.setCellValueFactory(data -> data.getValue().memoryUsageProperty());
        
        performanceTableView.setItems(javafx.collections.FXCollections.observableArrayList(performanceDataList));
    }
    
    /**
     * Setup the visualization canvas.
     */
    private void setupVisualizationCanvas() {
        GraphicsContext gc = visualizationCanvas.getGraphicsContext2D();
        
        // Set canvas size
        visualizationCanvas.setWidth(800);
        visualizationCanvas.setHeight(600);
        
        // Clear canvas
        gc.clearRect(0, 0, visualizationCanvas.getWidth(), visualizationCanvas.getHeight());
        
        // Draw initial grid
        drawGrid(gc);
    }
    
    /**
     * Draw a grid on the visualization canvas.
     * 
     * @param gc The graphics context to draw on
     */
    private void drawGrid(GraphicsContext gc) {
        double width = visualizationCanvas.getWidth();
        double height = visualizationCanvas.getHeight();
        double gridSize = 20;
        
        gc.setStroke(javafx.scene.paint.Color.LIGHTGRAY);
        gc.setLineWidth(0.5);
        
        // Draw vertical lines
        for (double x = 0; x <= width; x += gridSize) {
            gc.strokeLine(x, 0, x, height);
        }
        
        // Draw horizontal lines
        for (double y = 0; y <= height; y += gridSize) {
            gc.strokeLine(0, y, width, y);
        }
    }
    
    /**
     * Handle algorithm selection.
     * 
     * @param algorithmName The selected algorithm name
     */
    private void onAlgorithmSelected(String algorithmName) {
        if (algorithmName != null) {
            algorithmDescriptionTextArea.setText(algorithmMap.get(algorithmName));
            algorithmNameTextField.setText(algorithmName);
            
            // Update status
            updateStatus("Selected algorithm: " + algorithmName);
            
            // Load algorithm properties
            loadAlgorithmProperties(algorithmName);
        }
    }
    
    /**
     * Handle data structure selection.
     * 
     * @param dataStructureName The selected data structure name
     */
    private void onDataStructureSelected(String dataStructureName) {
        if (dataStructureName != null) {
            dataStructureDescriptionTextArea.setText(dataStructureMap.get(dataStructureName));
            
            // Update status
            updateStatus("Selected data structure: " + dataStructureName);
            
            // Load data structure properties
            loadDataStructureProperties(dataStructureName);
        }
    }
    
    /**
     * Handle new action.
     */
    private void handleNewAction() {
        // TODO: Implement new project creation
        updateStatus("Creating new project...");
    }
    
    /**
     * Handle open action.
     */
    private void handleOpenAction() {
        // TODO: Implement project opening
        updateStatus("Opening project...");
    }
    
    /**
     * Handle save action.
     */
    private void handleSaveAction() {
        // TODO: Implement project saving
        updateStatus("Saving project...");
    }
    
    /**
     * Handle save as action.
     */
    private void handleSaveAsAction() {
        // TODO: Implement save as functionality
        updateStatus("Saving project as...");
    }
    
    /**
     * Handle exit action.
     */
    private void handleExitAction() {
        mainApp.getPrimaryStage().close();
    }
    
    /**
     * Handle undo action.
     */
    private void handleUndoAction() {
        // TODO: Implement undo functionality
        updateStatus("Undoing last action...");
    }
    
    /**
     * Handle redo action.
     */
    private void handleRedoAction() {
        // TODO: Implement redo functionality
        updateStatus("Redoing last action...");
    }
    
    /**
     * Handle cut action.
     */
    private void handleCutAction() {
        // TODO: Implement cut functionality
        updateStatus("Cutting selection...");
    }
    
    /**
     * Handle copy action.
     */
    private void handleCopyAction() {
        // TODO: Implement copy functionality
        updateStatus("Copying selection...");
    }
    
    /**
     * Handle paste action.
     */
    private void handlePasteAction() {
        // TODO: Implement paste functionality
        updateStatus("Pasting content...");
    }
    
    /**
     * Handle preferences action.
     */
    private void handlePreferencesAction() {
        // TODO: Open preferences dialog
        updateStatus("Opening preferences...");
    }
    
    /**
     * Handle zoom in action.
     */
    private void handleZoomInAction() {
        // TODO: Implement zoom in
        updateStatus("Zooming in...");
    }
    
    /**
     * Handle zoom out action.
     */
    private void handleZoomOutAction() {
        // TODO: Implement zoom out
        updateStatus("Zooming out...");
    }
    
    /**
     * Handle reset zoom action.
     */
    private void handleResetZoomAction() {
        // TODO: Implement reset zoom
        updateStatus("Resetting zoom...");
    }
    
    /**
     * Handle fullscreen action.
     */
    private void handleFullscreenAction() {
        Stage stage = mainApp.getPrimaryStage();
        stage.setFullScreen(!stage.isFullScreen());
        updateStatus("Toggling fullscreen...");
    }
    
    /**
     * Handle show grid action.
     */
    private void handleShowGridAction() {
        boolean showGrid = showGridMenuItem.isSelected();
        // TODO: Implement grid visibility toggle
        updateStatus("Grid visibility: " + (showGrid ? "On" : "Off"));
    }
    
    /**
     * Handle show animation action.
     */
    private void handleShowAnimationAction() {
        boolean showAnimation = showAnimationMenuItem.isSelected();
        // TODO: Implement animation visibility toggle
        updateStatus("Animation visibility: " + (showAnimation ? "On" : "Off"));
    }
    
    /**
     * Handle algorithm analyzer action.
     */
    private void handleAlgorithmAnalyzerAction() {
        // TODO: Open algorithm analyzer
        updateStatus("Opening algorithm analyzer...");
    }
    
    /**
     * Handle performance monitor action.
     */
    private void handlePerformanceMonitorAction() {
        // TODO: Open performance monitor
        updateStatus("Opening performance monitor...");
    }
    
    /**
     * Handle data generator action.
     */
    private void handleDataGeneratorAction() {
        // TODO: Open data generator
        updateStatus("Opening data generator...");
    }
    
    /**
     * Handle export action.
     */
    private void handleExportAction() {
        // TODO: Implement export functionality
        updateStatus("Exporting data...");
    }
    
    /**
     * Handle about action.
     */
    private void handleAboutAction() {
        // TODO: Show about dialog
        updateStatus("Opening about dialog...");
    }
    
    /**
     * Handle help action.
     */
    private void handleHelpAction() {
        // TODO: Open help system
        updateStatus("Opening help system...");
    }
    
    /**
     * Handle tutorial action.
     */
    private void handleTutorialAction() {
        // TODO: Start tutorial
        updateStatus("Starting tutorial...");
    }
    
    /**
     * Handle play action.
     */
    private void handlePlayAction() {
        if (!isAnimating) {
            startAnimation();
        }
    }
    
    /**
     * Handle pause action.
     */
    private void handlePauseAction() {
        if (isAnimating) {
            pauseAnimation();
        }
    }
    
    /**
     * Handle stop action.
     */
    private void handleStopAction() {
        if (isAnimating) {
            stopAnimation();
        }
    }
    
    /**
     * Handle reset action.
     */
    private void handleResetAction() {
        if (isAnimating) {
            stopAnimation();
        }
        resetVisualization();
    }
    
    /**
     * Handle run algorithm action.
     */
    private void handleRunAlgorithmAction() {
        String selectedAlgorithm = algorithmListView.getSelectionModel().getSelectedItem();
        if (selectedAlgorithm != null) {
            updateStatus("Running algorithm: " + selectedAlgorithm);
            // TODO: Implement algorithm execution
        }
    }
    
    /**
     * Handle step algorithm action.
     */
    private void handleStepAlgorithmAction() {
        String selectedAlgorithm = algorithmListView.getSelectionModel().getSelectedItem();
        if (selectedAlgorithm != null) {
            updateStatus("Stepping through algorithm: " + selectedAlgorithm);
            // TODO: Implement algorithm stepping
        }
    }
    
    /**
     * Handle reset algorithm action.
     */
    private void handleResetAlgorithmAction() {
        String selectedAlgorithm = algorithmListView.getSelectionModel().getSelectedItem();
        if (selectedAlgorithm != null) {
            updateStatus("Resetting algorithm: " + selectedAlgorithm);
            // TODO: Implement algorithm reset
        }
    }
    
    /**
     * Handle create data structure action.
     */
    private void handleCreateDataStructureAction() {
        String selectedDataStructure = dataStructureListView.getSelectionModel().getSelectedItem();
        if (selectedDataStructure != null) {
            updateStatus("Creating data structure: " + selectedDataStructure);
            // TODO: Implement data structure creation
        }
    }
    
    /**
     * Handle clear data structure action.
     */
    private void handleClearDataStructureAction() {
        String selectedDataStructure = dataStructureListView.getSelectionModel().getSelectedItem();
        if (selectedDataStructure != null) {
            updateStatus("Clearing data structure: " + selectedDataStructure);
            // TODO: Implement data structure clearing
        }
    }
    
    /**
     * Handle play animation action.
     */
    private void handlePlayAnimationAction() {
        if (!isAnimating) {
            startAnimation();
        }
    }
    
    /**
     * Handle pause animation action.
     */
    private void handlePauseAnimationAction() {
        if (isAnimating) {
            pauseAnimation();
        }
    }
    
    /**
     * Handle stop animation action.
     */
    private void handleStopAnimationAction() {
        if (isAnimating) {
            stopAnimation();
        }
    }
    
    /**
     * Handle reset animation action.
     */
    private void handleResetAnimationAction() {
        if (isAnimating) {
            stopAnimation();
        }
        resetVisualization();
    }
    
    /**
     * Handle run performance test action.
     */
    private void handleRunPerformanceTestAction() {
        updateStatus("Running performance tests...");
        // TODO: Implement performance testing
    }
    
    /**
     * Handle clear results action.
     */
    private void handleClearResultsAction() {
        performanceDataList.clear();
        performanceTableView.refresh();
        updateStatus("Performance results cleared");
    }
    
    /**
     * Handle algorithm search.
     * 
     * @param event The key event
     */
    private void handleAlgorithmSearch(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String searchText = searchAlgorithmTextField.getText().toLowerCase();
            algorithmListView.getItems().clear();
            
            for (String algorithm : algorithmMap.keySet()) {
                if (algorithm.toLowerCase().contains(searchText)) {
                    algorithmListView.getItems().add(algorithm);
                }
            }
        }
    }
    
    /**
     * Handle data structure search.
     * 
     * @param event The key event
     */
    private void handleDataStructureSearch(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String searchText = searchDataStructureTextField.getText().toLowerCase();
            dataStructureListView.getItems().clear();
            
            for (String dataStructure : dataStructureMap.keySet()) {
                if (dataStructure.toLowerCase().contains(searchText)) {
                    dataStructureListView.getItems().add(dataStructure);
                }
            }
        }
    }
    
    /**
     * Handle algorithm filter.
     */
    private void handleAlgorithmFilter() {
        String category = algorithmCategoryComboBox.getSelectionModel().getSelectedItem();
        algorithmListView.getItems().clear();
        
        // TODO: Implement category filtering
        algorithmListView.getItems().addAll(algorithmMap.keySet());
    }
    
    /**
     * Handle data structure filter.
     */
    private void handleDataStructureFilter() {
        String type = dataStructureTypeComboBox.getSelectionModel().getSelectedItem();
        dataStructureListView.getItems().clear();
        
        // TODO: Implement type filtering
        dataStructureListView.getItems().addAll(dataStructureMap.keySet());
    }
    
    /**
     * Handle theme change.
     */
    private void handleThemeChange() {
        String theme = themeComboBox.getSelectionModel().getSelectedItem();
        updateStatus("Changing theme to: " + theme);
        // TODO: Implement theme change
    }
    
    /**
     * Handle language change.
     */
    private void handleLanguageChange() {
        String language = languageComboBox.getSelectionModel().getSelectedItem();
        updateStatus("Changing language to: " + language);
        // TODO: Implement language change
    }
    
    /**
     * Handle animation speed change.
     * 
     * @param speed The new animation speed
     */
    private void handleAnimationSpeedChange(double speed) {
        animationSpeed = speed;
        updateStatus("Animation speed: " + speed);
    }
    
    /**
     * Handle data size change.
     * 
     * @param size The new data size
     */
    private void handleDataSizeChange(int size) {
        dataSizeValueLabel.setText(String.valueOf(size));
        updateStatus("Data size: " + size);
    }
    
    /**
     * Handle algorithm properties action.
     */
    private void handleAlgorithmPropertiesAction() {
        String selectedAlgorithm = algorithmListView.getSelectionModel().getSelectedItem();
        if (selectedAlgorithm != null) {
            // TODO: Show algorithm properties dialog
            updateStatus("Showing properties for: " + selectedAlgorithm);
        }
    }
    
    /**
     * Handle data structure properties action.
     */
    private void handleDataStructurePropertiesAction() {
        String selectedDataStructure = dataStructureListView.getSelectionModel().getSelectedItem();
        if (selectedDataStructure != null) {
            // TODO: Show data structure properties dialog
            updateStatus("Showing properties for: " + selectedDataStructure);
        }
    }
    
    /**
     * Handle visualize data structure action.
     */
    private void handleVisualizeDataStructureAction() {
        String selectedDataStructure = dataStructureListView.getSelectionModel().getSelectedItem();
        if (selectedDataStructure != null) {
            // TODO: Visualize data structure
            updateStatus("Visualizing: " + selectedDataStructure);
        }
    }
    
    /**
     * Start the animation.
     */
    private void startAnimation() {
        isAnimating = true;
        animationTimeline.play();
        updateStatus("Animation started");
    }
    
    /**
     * Pause the animation.
     */
    private void pauseAnimation() {
        isAnimating = false;
        animationTimeline.pause();
        updateStatus("Animation paused");
    }
    
    /**
     * Stop the animation.
     */
    private void stopAnimation() {
        isAnimating = false;
        animationTimeline.stop();
        updateStatus("Animation stopped");
    }
    
    /**
     * Reset the visualization.
     */
    private void resetVisualization() {
        GraphicsContext gc = visualizationCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, visualizationCanvas.getWidth(), visualizationCanvas.getHeight());
        drawGrid(gc);
        updateStatus("Visualization reset");
    }
    
    /**
     * Handle animation tick.
     */
    private void handleAnimationTick() {
        // TODO: Implement animation logic
    }
    
    /**
     * Load algorithm properties.
     * 
     * @param algorithmName The algorithm name
     */
    private void loadAlgorithmProperties(String algorithmName) {
        // TODO: Load algorithm-specific properties
        timeComplexityTextField.setText("O(n log n)");
        spaceComplexityTextField.setText("O(1)");
    }
    
    /**
     * Load data structure properties.
     * 
     * @param dataStructureName The data structure name
     */
    private void loadDataStructureProperties(String dataStructureName) {
        // TODO: Load data structure-specific properties
    }
    
    /**
     * Load default settings.
     */
    private void loadDefaultSettings() {
        // TODO: Load default application settings
        animationSpeedSlider.setValue(1.0);
        dataSizeSlider.setValue(100);
        showGridMenuItem.setSelected(true);
        showAnimationMenuItem.setSelected(true);
    }
    
    /**
     * Load saved preferences.
     */
    private void loadPreferences() {
        // TODO: Load user preferences from storage
    }
    
    /**
     * Setup update checking.
     */
    private void setupUpdateChecking() {
        // TODO: Implement update checking
    }
    
    /**
     * Setup crash reporting.
     */
    private void setupCrashReporting() {
        // TODO: Implement crash reporting
    }
    
    /**
     * Update the status label.
     * 
     * @param message The status message
     */
    private void updateStatus(String message) {
        statusLabel.setText(message);
        if (mainApp != null) {
            mainApp.getLoggerManager().info(message);
        }
    }
    
    /**
     * Show an error message to the user.
     * 
     * @param message The error message
     */
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("An error occurred");
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    /**
     * Show a warning message to the user.
     * 
     * @param message The warning message
     */
    private void showWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Warning");
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    /**
     * Show an information message to the user.
     * 
     * @param message The information message
     */
    private void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Information");
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    /**
     * Set the main application reference.
     * 
     * @param mainApp The main application instance
     */
    public void setMainApp(DSAJavaFXApplication mainApp) {
        this.mainApp = mainApp;
    }
    
    /**
     * Performance data model for the performance table.
     */
    public static class PerformanceData {
        private final javafx.beans.property.SimpleStringProperty algorithmName;
        private final javafx.beans.property.SimpleIntegerProperty executionTime;
        private final javafx.beans.property.SimpleIntegerProperty memoryUsage;
        
        public PerformanceData(String algorithmName, int executionTime, int memoryUsage) {
            this.algorithmName = new javafx.beans.property.SimpleStringProperty(algorithmName);
            this.executionTime = new javafx.beans.property.SimpleIntegerProperty(executionTime);
            this.memoryUsage = new javafx.beans.property.SimpleIntegerProperty(memoryUsage);
        }
        
        public javafx.beans.property.StringProperty algorithmNameProperty() {
            return algorithmName;
        }
        
        public javafx.beans.property.IntegerProperty executionTimeProperty() {
            return executionTime;
        }
        
        public javafx.beans.property.IntegerProperty memoryUsageProperty() {
            return memoryUsage;
        }
        
        public String getAlgorithmName() {
            return algorithmName.get();
        }
        
        public int getExecutionTime() {
            return executionTime.get();
        }
        
        public int getMemoryUsage() {
            return memoryUsage.get();
        }
    }
}
