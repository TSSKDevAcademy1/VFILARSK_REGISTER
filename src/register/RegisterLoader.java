package register;

import java.io.IOException;

public interface RegisterLoader {

	void save(Register register) throws IOException;

	Register load() throws ClassNotFoundException, IOException;

}