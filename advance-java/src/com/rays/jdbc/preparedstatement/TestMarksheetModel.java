package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

		// add();//find wali v esi say chala giiii
		// update();
		// delete();
		search();

	}

	private static void add() throws Exception {

		MarksheetBean Bean = new MarksheetBean();

		MarksheetModel model = new MarksheetModel();

		Bean.setId(10);

		Bean.setRollno(109);

		Bean.setName("rishee");

		Bean.setPhysics(50);

		Bean.setChemistry(80);

		Bean.setMaths(70);

		model.add(Bean);

	}

	private static void update() throws Exception {

		MarksheetBean Bean = new MarksheetBean();

		MarksheetModel Model = new MarksheetModel();
		Bean.setId(1);
		Bean.setRollno(112);
		Bean.setName("uttam");
		Bean.setPhysics(80);
		Bean.setChemistry(70);
		Bean.setMaths(85);

		Bean.setId(9);

		Model.update(Bean);
	}

	private static void delete() throws Exception {

		MarksheetModel Model = new MarksheetModel();

		Model.delete(10);

	}

	private static void search() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		MarksheetModel model = new MarksheetModel();

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();

			System.out.print(  bean.getId());
			System.out.print("\t" + bean.getRollno());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());

		}

	}

}
