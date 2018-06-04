package $package$.impl

import $package$.plan.api._
import money.haven.utils.specs.{HavenSpec, ServiceSanitySpec}

class $service;format="Camel"$ServiceSanitySpec extends HavenSpec {
  describe("$service;format="Camel"$Service") {
    it("should describe all of its methods") {
      ServiceSanitySpec.assertSanity[$service;format="Camel"$Service](
        ServiceSanitySpec.getDescriptor[$service;format="Camel"$Service]
      )
    }
  }
}
