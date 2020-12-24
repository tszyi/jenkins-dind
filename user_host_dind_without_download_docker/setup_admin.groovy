import jenkins.security.s2m.AdminWhitelistRule
import jenkins.model.*
import hudson.security.*

println "--> Setting up admin user"

def adminUsername = "admin"
def adminPassword = "admin"

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount(adminUsername, adminPassword)
Jenkins.instance.setSecurityRealm(hudsonRealm)

def authorizationStrategy = new FullControlOnceLoggedInAuthorizationStrategy()
authorizationStrategy.setAllowAnonymousRead(false)
Jenkins.instance.setAuthorizationStrategy(authorizationStrategy)

Jenkins.instance.getInjector().getInstance(AdminWhitelistRule.class).setMasterKillSwitch(false)

Jenkins.instance.save()
