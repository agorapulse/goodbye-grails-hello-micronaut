package hello.legacy

import com.agorapulse.micronaut.grails.jpa.generator.MicronautJpaGenerator
import io.micronaut.context.ApplicationContext
import org.grails.datastore.gorm.validation.constraints.eval.DefaultConstraintEvaluator
import org.grails.orm.hibernate.HibernateDatastore
import spock.lang.AutoCleanup
import spock.lang.Ignore
import spock.lang.Specification

@Ignore
class MicronautGeneratorSpec extends Specification {

    @AutoCleanup ApplicationContext context = ApplicationContext.run()

    MicronautJpaGenerator generator = new MicronautJpaGenerator(
            context.getBean(HibernateDatastore),
            new DefaultConstraintEvaluator()
    )

    void 'generate domains'() {
        given:
            File root = new File(System.getProperty('project.root'), 'libs/hello-data/src/main/groovy')
        when:
            generator.generate(root)
        then:
            noExceptionThrown()
    }

}
