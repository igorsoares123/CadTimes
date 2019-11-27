package com.cadtimes.model;
	
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;

	@Entity
	public class Time{
		
		
		
		@Id
		@GeneratedValue
		
		private Long id;
		private String tecnico;
		private String time;
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}

		public String getTecnico() {
			return tecnico;
		}
		
		public void setTecnico(String tecnico) {
			this.tecnico = tecnico;
		}
		
		public String getTime() {
			return time;
		}
		
		public void setTime(String time) {
			this.time = time;
		}
		
	}

