package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import test.RadnjaTest;

class VulkanizerskaRadnjaTest extends RadnjaTest {



	@Override
	public Radnja getInstance() {
		// TODO Auto-generated method stub
		return new VulkanizerskaRadnja();
	}

}
