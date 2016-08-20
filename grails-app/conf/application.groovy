// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'org.repairmanager.domains.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'org.repairmanager.domains.UserRole'
grails.plugin.springsecurity.authority.className = 'org.repairmanager.domains.Role'
grails.plugin.springsecurity.rest.token.validation.enableAnonymousAccess = true
grails.plugin.springsecurity.filterChain.chainMap = [
        [
                pattern: '/api/**',
                filters: 'JOINED_FILTERS,' +
                         '-anonymousAuthenticationFilter,' +
                         '-exceptionTranslationFilter,' +
                         '-authenticationProcessingFilter,' +
                         '-securityContextPersistenceFilter,' +
                         '-rememberMeAuthenticationFilter'
        ]
]