package jmp.training.one.core;

import java.util.List;

public interface Figure extends Volumetric {
	
	public boolean add(Volumetric obj);
	List<Volumetric> getAll();
	
}
