package de.FBEditor.utils;

public class LogSeverity {

	private final int id;
	private final String name;
	private final String prefix;
	
	public LogSeverity(int id, String name, String prefix)
	{
		this.id = id;
		this.name = name;
		this.prefix = prefix;
	}
	
        @Override
	public String toString() {
		return name;
	}
	
	public int getId()
	{
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getPrefix() {
		return prefix;
	}
}
