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
]
System.setProperty(
        'enterprise.groovy.conventions',
        "conventions=${conventions.inspect()}"
)