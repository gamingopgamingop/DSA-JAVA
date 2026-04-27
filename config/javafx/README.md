# JavaFX Configuration for DSA Java Project

This directory contains comprehensive JavaFX configuration files for creating a modern, feature-rich GUI application for visualizing Data Structures and Algorithms.

## 📁 Directory Structure

```
config/javafx/
├── javafx-build.gradle           # JavaFX build configuration
├── javafx-application.properties # Application properties
├── templates/                    # Application templates
│   ├── DSAJavaFXApplication.java # Main application class
│   ├── controllers/              # FXML controllers
│   │   └── MainController.java   # Main controller
│   └── fxml/                     # FXML layout files
│       ├── main.fxml            # Main application layout
│       └── algorithm-dialog.fxml # Algorithm properties dialog
├── styles/                       # CSS styling
│   ├── main.css                  # Main stylesheet
│   └── material-light.css        # Material Design light theme
└── README.md                     # This file
```

## 🚀 Quick Start

### 1. Apply JavaFX Build Configuration

Add the JavaFX build configuration to your `build.gradle`:

```gradle
apply from: 'config/javafx/javafx-build.gradle'
```

### 2. Run the JavaFX Application

```bash
./gradlew runJavaFX
```

### 3. Build Executable JAR

```bash
./gradlew createJavaFXJar
```

## 🔧 Configuration Details

### Build Configuration (`javafx-build.gradle`)

- **JavaFX Version**: 21
- **Modules**: controls, fxml, graphics, base
- **Platform Support**: Windows, macOS, Linux
- **Dependencies**: ControlsFX, JFoenix, TestFX
- **JVM Options**: Proper module exports for JavaFX
- **Testing**: Headless mode support with TestFX

### Application Properties (`javafx-application.properties`)

- **Window Configuration**: Size, position, behavior
- **Theme Settings**: Material Design colors and fonts
- **Animation Settings**: Speed and duration controls
- **Performance**: Memory and FPS limits
- **Logging**: Configurable logging levels and outputs
- **Internationalization**: Multi-language support
- **Accessibility**: High contrast and large text options

### Application Templates

#### Main Application Class (`DSAJavaFXApplication.java`)

- **Lifecycle Management**: Proper initialization and cleanup
- **Configuration Loading**: Properties and theme management
- **Internationalization**: Resource bundle support
- **Error Handling**: Graceful error dialogs
- **Event Management**: Window events and keyboard shortcuts

#### Main Controller (`MainController.java`)

- **MVC Architecture**: Clean separation of concerns
- **Event Handling**: Comprehensive UI event management
- **Data Management**: Algorithm and data structure models
- **Visualization**: Canvas-based algorithm visualization
- **Performance**: Real-time performance monitoring
- **Accessibility**: Keyboard navigation and screen reader support

#### FXML Layouts

- **Main Layout** (`main.fxml`): Complete application interface
- **Algorithm Dialog** (`algorithm-dialog.fxml`): Properties and configuration
- **Responsive Design**: Adapts to different screen sizes
- **Accessibility**: Proper ARIA labels and semantic structure

### Styling System

#### Main Stylesheet (`main.css`)

- **Comprehensive Styling**: All JavaFX components styled
- **Material Design**: Modern, consistent visual language
- **Responsive Design**: Media queries for different screen sizes
- **Dark Theme**: Complete dark mode support
- **Accessibility**: High contrast and large text variants
- **Animations**: Smooth transitions and micro-interactions

#### Material Design Theme (`material-light.css`)

- **Material Design 3.0**: Latest Material Design specifications
- **Color System**: Complete Material Design color palette
- **Typography**: Roboto font family with proper hierarchy
- **Elevation**: Material Design shadow system
- **Components**: All Material Design components implemented
- **Animation**: Material Design motion system

## 🎯 Features

### Algorithm Visualization
- **Interactive Canvas**: Real-time algorithm visualization
- **Animation Controls**: Play, pause, step, reset
- **Speed Control**: Adjustable animation speed
- **Grid System**: Snap-to-grid functionality
- **Color Coding**: Visual state indicators

### Data Structure Management
- **Dynamic Creation**: Create and modify data structures
- **Visualization**: Graphical representation of structures
- **Operations**: Add, remove, modify elements
- **Performance**: Real-time performance metrics

### Performance Monitoring
- **Real-time Metrics**: CPU, memory, execution time
- **Charts**: Performance graphs and comparisons
- **Benchmarks**: Algorithm performance testing
- **Profiling**: Detailed performance analysis

### User Interface
- **Material Design**: Modern, intuitive interface
- **Responsive Layout**: Adapts to screen size
- **Keyboard Shortcuts**: Efficient navigation
- **Accessibility**: Screen reader and high contrast support
- **Internationalization**: Multi-language support

## 🛠️ Development

### Adding New Algorithms

1. Create algorithm class in `src/main/java/com/dsa/algorithms/`
2. Add to `algorithmMap` in `MainController.java`
3. Create FXML dialog for algorithm properties
4. Add visualization logic to canvas
5. Update performance metrics

### Adding New Data Structures

1. Create data structure class in `src/main/java/com/dsa/datastructures/`
2. Add to `dataStructureMap` in `MainController.java`
3. Create visualization methods
4. Add performance monitoring
5. Update documentation

### Customizing Themes

1. Copy `material-light.css` to new theme file
2. Modify color variables and component styles
3. Add theme to theme selection combo box
4. Test with different components
5. Update documentation

### Adding New Languages

1. Create `messages_xx.properties` file
2. Translate all UI strings
3. Add language to selection combo box
4. Test with different locales
5. Update documentation

## 📊 Performance

### Optimization Techniques
- **Lazy Loading**: Components loaded on demand
- **Caching**: Frequent operations cached
- **Efficient Rendering**: Canvas optimization
- **Memory Management**: Proper cleanup and garbage collection
- **Animation Performance**: Smooth 60fps animations

### Benchmarks
- **Startup Time**: < 2 seconds
- **Memory Usage**: < 512MB baseline
- **Animation FPS**: 60fps target
- **Algorithm Visualization**: Real-time for n < 1000

## 🔍 Testing

### Unit Tests
- **Controller Logic**: Business logic testing
- **Data Models**: Model validation
- **Utilities**: Helper function testing
- **Configuration**: Property loading testing

### Integration Tests
- **FXML Loading**: Layout validation
- **Event Handling**: User interaction testing
- **Performance**: Load testing
- **Accessibility**: Screen reader testing

### UI Tests
- **TestFX**: Automated UI testing
- **Headless Mode**: CI/CD testing
- **Cross-Platform**: Windows, macOS, Linux testing
- **Accessibility**: Accessibility testing tools

## 🌐 Internationalization

### Supported Languages
- **English** (en_US) - Default
- **Spanish** (es_ES)
- **French** (fr_FR)
- **German** (de_DE)
- **Italian** (it_IT)
- **Portuguese** (pt_BR)
- **Chinese** (zh_CN)
- **Japanese** (ja_JP)

### Adding New Languages
1. Create `messages_xx.properties` file
2. Translate all strings from `messages.properties`
3. Add locale to `javafx-application.properties`
4. Test with new locale
5. Update documentation

## ♿ Accessibility

### Features
- **Keyboard Navigation**: Full keyboard access
- **Screen Reader**: ARIA labels and descriptions
- **High Contrast**: High contrast theme support
- **Large Text**: Scalable font sizes
- **Focus Management**: Proper focus handling
- **Color Blindness**: Alternative color schemes

### Testing Tools
- **JAWS**: Windows screen reader testing
- **VoiceOver**: macOS screen reader testing
- **Orca**: Linux screen reader testing
- **Color Blindness Simulators**: Color accessibility testing

## 📱 Platform Support

### Windows
- **Windows 10/11**: Full support
- **Windows 8.1**: Limited support
- **Windows 7**: No support (JavaFX 21 requires Windows 10+)

### macOS
- **macOS 11+**: Full support
- **macOS 10.15**: Limited support
- **macOS 10.14**: No support

### Linux
- **Ubuntu 20.04+**: Full support
- **Fedora 33+**: Full support
- **Arch Linux**: Full support
- **Other distributions**: Community support

## 🔧 Troubleshooting

### Common Issues

#### JavaFX Not Found
```bash
# Ensure JavaFX is properly configured
./gradlew dependencies | grep javafx
```

#### Module Access Errors
```bash
# Check JVM arguments
./gradlew runJavaFX --info | grep -i jvm
```

#### CSS Not Loading
```bash
# Verify CSS file paths
find . -name "*.css" -type f
```

#### FXML Loading Issues
```bash
# Validate FXML syntax
xmllint --noout config/javafx/templates/fxml/*.fxml
```

### Debug Mode
```bash
# Enable debug logging
./gradlew runJavaFX -Dlogging.level=DEBUG
```

### Performance Issues
```bash
# Enable performance monitoring
./gradlew runJavaFX -Dperformance.monitoring=true
```

## 📚 Documentation

### API Documentation
```bash
# Generate Javadoc
./gradlew generateJavaFXDoc
```

### User Guide
- **Getting Started**: Installation and setup
- **User Interface**: Complete UI guide
- **Algorithms**: Algorithm visualization guide
- **Data Structures**: Data structure management
- **Performance**: Performance optimization

### Developer Guide
- **Architecture**: System architecture overview
- **Contributing**: Development guidelines
- **Testing**: Testing strategies
- **Deployment**: Build and deployment guide

## 🔄 Version History

### v1.0.0 (Current)
- **Initial Release**: Complete JavaFX application
- **Material Design**: Modern UI implementation
- **Algorithm Visualization**: Interactive algorithm display
- **Performance Monitoring**: Real-time metrics
- **Internationalization**: Multi-language support
- **Accessibility**: Full accessibility support

### Future Releases
- **v1.1.0**: Enhanced visualization features
- **v1.2.0**: Cloud synchronization
- **v1.3.0**: Mobile support (JavaFX on Android)
- **v2.0.0**: Web version (GluonFX)

## 🤝 Contributing

### Development Setup
1. Clone repository
2. Install Java 17+ and JavaFX 21
3. Import into IDE with JavaFX support
4. Run `./gradlew runJavaFX` to test
5. Follow coding standards in `CONTRIBUTING.md`

### Code Style
- **Java**: Follow Google Java Style Guide
- **CSS**: Follow CSS Style Guide
- **FXML**: Follow FXML Best Practices
- **Documentation**: Javadoc comments required

### Testing Requirements
- **Unit Tests**: 80% coverage minimum
- **UI Tests**: All major workflows tested
- **Accessibility**: Screen reader tested
- **Performance**: Load tested

## 📄 License

This project is licensed under the MIT License. See `LICENSE` file for details.

## 🔗 Related Resources

- [JavaFX Documentation](https://openjfx.io/)
- [Material Design Guidelines](https://material.io/design/)
- [JavaFX Best Practices](https://github.com/openjfx/samples)
- [TestFX Documentation](https://testfx.org/)
- [ControlsFX Documentation](https://controlsfx.github.io/controlsfx/)

---

*Last updated: 2024-04-27*  
*Maintained by: DSA Java Project Team*
