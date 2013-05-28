package main.edu.pwu.dao;

import java.util.List;

import main.edu.pwu.model.Subject;

public interface SubjectDao {
	public void add(Subject subject);
	public void update(Subject subject);
	public void delete(Subject subject);
	public Subject get(String code);
	public List<Subject> getAll();
}
