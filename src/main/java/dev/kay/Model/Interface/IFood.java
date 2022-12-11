package Interface;

import java.io.IOException;

public interface IFood {
    public void ExportList();
	public void Add();	
	public void Remove();
	public void Edit();
    public void ReadFile() throws IOException;
	public void WriteFile() throws IOException;
}
