Map conventions = [
        disable                     : false,
        whiteListScripts            : true,
        disableDynamicCompile       : false,
        dynamicCompileWhiteList     : [
                'UrlMappings',
                'Application',
                'BootStrap',
                'resources',
                'org.grails.cli'
        ],
        limitCompileStaticExtensions: false,
        defAllowed                  : false,    // For controllers you can use Object in place of def, and in Domains add Closure to constraints/mappings closure fields.
        skipDefaultPackage          : true,     // For GSP files
        compileStaticExtensions     : [
                'org.grails.compiler.ValidateableTypeCheckingExtension',
                'org.grails.compiler.NamedQueryTypeCheckingExtension',
                'org.grails.compiler.HttpServletRequestTypeCheckingExtension',
                'org.grails.compiler.WhereQueryTypeCheckingExtension',
                'org.grails.compiler.DynamicFinderTypeCheckingExtension',
                'org.grails.compiler.DomainMappingTypeCheckingExtension',
                'org.grails.compiler.RelationshipManagementMethodTypeCheckingExtension'
        ],
]
System.setProperty(
        'enterprise.groovy.conventions',
        "conventions=${conventions.inspect()}"
)