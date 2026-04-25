# Documentation Templates

This directory contains reusable templates for creating consistent documentation across the DSA Java project.

## 📁 Available Templates

### Algorithm Documentation
- **[algorithm-template.md](algorithm-template.md)** - Template for algorithm documentation
- **[data-structure-template.md](data-structure-template.md)** - Template for data structure documentation

### Testing Documentation
- **[test-template.md](test-template.md)** - Template for test documentation
- **[test-case-template.md](test-case-template.md)** - Template for individual test cases

### General Documentation
- **[readme-template.md](readme-template.md)** - Template for README files
- **[contribution-template.md](contribution-template.md)** - Template for contribution guides

## 🎯 Usage Guidelines

### How to Use Templates
1. **Copy Template**: Copy the appropriate template to your target location
2. **Replace Placeholders**: Replace all placeholder text with actual content
3. **Customize**: Adapt the template to your specific needs
4. **Review**: Ensure all sections are relevant and complete

### Template Placeholders
- **`{{ALGORITHM_NAME}}`**: Replace with actual algorithm name
- **`{{CLASS_NAME}}`**: Replace with actual class name
- **`{{DESCRIPTION}}`**: Replace with algorithm description
- **`{{COMPLEXITY}}`**: Replace with time/space complexity
- **`{{EXAMPLES}}`**: Replace with usage examples

## 📝 Template Standards

### Formatting Guidelines
- **Markdown**: Use GitHub-flavored Markdown
- **Headings**: Use ATX style headings (# ## ###)
- **Code Blocks**: Use triple backticks with language
- **Links**: Use relative links for internal references

### Content Standards
- **Completeness**: Fill all relevant sections
- **Accuracy**: Ensure all information is correct
- **Clarity**: Write clear, concise documentation
- **Consistency**: Follow established patterns

## 🔧 Template Customization

### Adding New Sections
```markdown
## New Section
Content for the new section...
```

### Modifying Existing Sections
- **Keep Structure**: Maintain the overall template structure
- **Update Examples**: Provide relevant examples
- **Add Details**: Include specific implementation details

## 📋 Template Checklist

### Before Using a Template
- [ ] Choose the appropriate template
- [ ] Review all sections
- [ ] Identify placeholders to replace
- [ ] Plan customizations needed

### After Using a Template
- [ ] Replace all placeholders
- [ ] Verify all links work
- [ ] Check formatting consistency
- [ ] Review for completeness

## 🔗 Template Relationships

### Algorithm Documentation Flow
```
algorithm-template.md
├── Overview
├── Algorithm Summary
├── Class Structure
├── Core Algorithm
├── Analysis
├── User Interface
├── Usage Examples
└── Comparison
```

### Test Documentation Flow
```
test-template.md
├── Test Coverage
├── Algorithm Summary
├── Performance Analysis
├── Edge Cases
├── Error Handling
└── Usage Examples
```

## 🎨 Template Styling

### Markdown Elements
- **Headers**: Use consistent header levels
- **Lists**: Use unordered lists for general items
- **Code**: Use syntax highlighting
- **Tables**: Use for comparisons and data

### Visual Elements
- **Badges**: Use for status indicators
- **Icons**: Use emoji for visual emphasis
- **Diagrams**: Use ASCII art for simple diagrams
- **Images**: Store in `../assets/` directory

## 🔄 Template Maintenance

### Regular Updates
- **Review Templates**: Periodically review for relevance
- **Add New Templates**: Create templates for new document types
- **Update Examples**: Keep examples current and relevant
- **Improve Guidelines**: Refine usage guidelines

### Version Control
- **Track Changes**: Use version control for template updates
- **Document Changes**: Maintain changelog for templates
- **Backward Compatibility**: Maintain compatibility with existing docs

## 🔗 Related Documentation

- **[Architecture Guide](../architecture/)** - Project architecture and design
- **[Style Guide](../STYLE_GUIDE.md)** - Documentation writing standards
- **[Examples](../examples/)** - Usage examples and patterns
- **[Contributing Guide](../../CONTRIBUTING.md)** - How to contribute

---

*For questions about templates, please refer to the [main documentation](../README.md).*
