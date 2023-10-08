package com.parimal.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.parimal.entity.StudentEntity;
import com.parimal.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentEntity createStudent(StudentEntity studentEntity)
	{
		return studentRepository.save(studentEntity);
	}

	@Override
	public StudentEntity deleteStudent(Long id)
	{
		StudentEntity studentEntity = new StudentEntity();
		try
		{
			studentEntity = studentRepository.findById(id).orElseThrow(() -> new Exception("Data nt found"));
			studentRepository.deleteById(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return studentEntity;
	}

	@Override
	public List<StudentEntity> viewAllStudent()
	{
		return studentRepository.findAll();
	}

	@Override
	public StudentEntity updateStudent(Long id, StudentEntity studentEntity)
	{
		StudentEntity studentEntity1 = new StudentEntity();
		try
		{
			studentEntity1 = studentRepository.findById(id).orElseThrow(() -> new Exception("Data nt found"));
			BeanUtils.copyProperties(studentEntity, studentEntity1);
			studentEntity1.setId(studentEntity1.getId());
			studentRepository.save(studentEntity1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return studentEntity1;
	}

	@Override
	public List<StudentEntity> uploadThroughCSV(MultipartFile file)
	{
		List<StudentEntity> csvContent;
		try
		{
			// Building CSV to PurchaserBrandLimitCSV List
			String csvAsString = new String(file.getBytes());
			CsvMapper mapper = new CsvMapper();
			CsvSchema schema = mapper.schemaFor(StudentEntity.class).withHeader().withColumnReordering(true)
					.withNullValue("");

			try (MappingIterator<StudentEntity> it = mapper.readerFor(StudentEntity.class).with(schema)
					.readValues(csvAsString))
			{

				csvContent = new ArrayList<>();

				while (it.hasNext())
				{
					csvContent.add(it.next());
				}
			}

			studentRepository.saveAll(csvContent);

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return studentRepository.findAll();
	}

}
