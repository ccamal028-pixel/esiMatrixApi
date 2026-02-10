import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyStepdefsCalculator {

    int result;

    @Given("I have a Calculator")
    public void iHaveACalculator() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("I add {int} and {int}")
    public void iAddAnd(int a, int b) {
        // Write code here that turns the phrase above into concrete actions
        result = a+b;
    }

    @Then("The result shoulmd be {int}")
    public void theResultShoulmdBe(int c) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(c, result);
    }
}
