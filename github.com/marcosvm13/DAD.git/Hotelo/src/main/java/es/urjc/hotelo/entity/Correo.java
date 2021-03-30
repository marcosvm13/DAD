package es.urjc.hotelo.entity;

public class Correo {
		String email;
		String content;
		String subject;
		
		 public Correo() {
			 
		    }
		public Correo(String email, String content, String subject) {
			super();
			this.email = email;
			this.content = content;
			this.subject = subject;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}		

		
}
