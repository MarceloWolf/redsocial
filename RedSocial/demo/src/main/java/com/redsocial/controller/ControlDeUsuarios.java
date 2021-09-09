package com.redsocial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.redsocial.modelo.Amigo;
import com.redsocial.modelo.Chat;
import com.redsocial.modelo.Administrador;
import com.redsocial.modelo.Ciudad;
import com.redsocial.modelo.Comentario;
import com.redsocial.modelo.Mensaje;
import com.redsocial.modelo.Pais;
import com.redsocial.modelo.Publicacion;
import com.redsocial.modelo.Solicitud;
import com.redsocial.modelo.Usuario;


public class ControlDeUsuarios implements Serializable {

	/**
	 * AUTOR: Marcelo Wolf
	 */
	private static final long serialVersionUID = 7241411234548739669L;
	private EntityManagerFactory emf;
	private EntityManager em;

	/**
	 * 
	 * VARIABLES A UTILIZAR EN LA SESSION DE CADA USUARIO!
	 * 
	 */
	private String kk = "DSFDSFSDF989SDAS$";
	private String correo;
	private String clave;
	private String busqueda;
	private String publicacion;
	private String comentario;
	private String msj;
	private String ciudad;
	private String pais;
	
	private Usuario user ;
	private Usuario userRegistro;
	private Usuario userAmigo;
	/**
	 * 
	 * lISTAS A UTILIZAR EN LA SESSION DE CADA USUARIO!
	 * 
	 */
	private List<Ciudad> ciudades ;
	private List<Usuario> resultado;
	private List<Publicacion> misPublicaciones;
	private List<Comentario> comentarios;
	private List<Publicacion> publicacionesAmigo;
	private List<Pais> paises ;
	private List<Solicitud> misSolicitudes;
	private List<Chat> chats;
	private List<Mensaje> mensajes;
	private ArrayList<Publicacion> publicacionesInicio;

	private Chat chat;
	private Solicitud solicitud;
	private Publicacion p = new Publicacion();

	// gets y sets

public String getKk() {
	return kk;
}

public void setKk(String kk) {
	this.kk = kk;
}
	public ArrayList<Publicacion> getPublicacionesInicio() {
		return publicacionesInicio;
	}

	public void setPublicacionesInicio(ArrayList<Publicacion> publicacionesInicio) {
		this.publicacionesInicio = publicacionesInicio;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	public List<Solicitud> getMisSolicitudes() {
		return misSolicitudes;
	}

	public void setMisSolicitudes(List<Solicitud> misSolicitudes) {
		this.misSolicitudes = misSolicitudes;
	}

	public Usuario getUserAmigo() {
		return userAmigo;
	}

	public void setUserAmigo(Usuario userAmigo) {
		this.userAmigo = userAmigo;
	}	
	public Publicacion getP() {
		return p;
	}

	public void setP(Publicacion p) {
		this.p = p;
	}
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}


	public Usuario getUserRegistro() {
		return userRegistro;
	}

	public void setUserRegistro(Usuario userRegistro) {
		this.userRegistro = userRegistro;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsuario() {
		return correo;
	}

	public void setUsuario(String usuario) {
		this.correo = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	public List<Usuario> getResultado() {
		return resultado;
	}

	public void setResultado(List<Usuario> resultado) {
		this.resultado = resultado;
	}
	public String getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(String publicacion) {
		this.publicacion = publicacion;
	}

	public List<Publicacion> getMisPublicaciones() {
		return misPublicaciones;
	}

	public void setMisPublicaciones(List<Publicacion> misPublicaciones) {
		this.misPublicaciones = misPublicaciones;
	}
	

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
	
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}
	
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Publicacion> getPublicacionesAmigo() {
		return publicacionesAmigo;
	}

	public void setPublicacionesAmigo(List<Publicacion> publicacionesAmigo) {
		this.publicacionesAmigo = publicacionesAmigo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public List<Chat> getChats() {
		return chats;
	}

	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
	
	// constructor
/**
 * 
 * Constructor de el bean en donde se crea un entity manager y se inicialisan las variables
 *  para login  y el registro 
 */
	public ControlDeUsuarios() {
		try {
			this.emf = Persistence.createEntityManagerFactory("xxx_social");
			this.em = this.emf.createEntityManager();
			user=new Usuario();
			userRegistro=new Usuario();
			userAmigo = new Usuario();
			p = new Publicacion();
			comentario = new String();
			publicacionesInicio = new ArrayList<>();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	
	
	
	// Metodos Privados

/*
 * 
 *  Metodo que va a  la base de Datos y consulta los paises para mostrar en registro y configuracion
 */
	public List<Pais> consultarPaises() {
		try{
		String jpql = " SELECT p FROM Pai p";
		Query query = this.em.createQuery(jpql);
		paises = query.getResultList();

		return paises;
	
		}catch(Exception e){
			System.out.println("Error-: "+e.toString());
		}
		
		return paises;
		}

	
	/**
	 * 
	 * 
	 * Metodo que en base a un pais selecionado de la anterior consulta
	 * vuelve a la base de datos y consulta las ciudades de ese pais!
	 * esta funcion se utiliza en el registro
	 */
	public void consultarCiudades() {

		String jpql = " SELECT p FROM Ciudad p 	WHERE p.pai.nombre = :pais";

		Query query = this.em.createQuery(jpql);
		query.setParameter("pais",this.userRegistro.getPais());

		ciudades = query.getResultList();

	}
	

	/**
	 * 
	 * 
	 * Metodo que en base a un pais selecionado de la anterior consulta
	 * vuelve a la base de datos y consulta las ciudades de ese pais!
	 * esta funcion se utiliza en la configuracion del perfil
	 */
	public void consultarCiudadesC() {

		String jpql = " SELECT p FROM Ciudad p 	WHERE p.pai.nombre = :pais";

		Query query = this.em.createQuery(jpql);
		query.setParameter("pais",this.pais);

		ciudades = query.getResultList();

	}
	
	
	/**
	 * 
	 * Esta es el metodo que registra un nuevo usuario en la base de datos
	 *  y cifra la contraseña con un hash SHA256
	 * 
	 */
	public boolean registro() {

		try {
			this.em = this.emf.createEntityManager();

			this.em.getTransaction().begin();

			this.userRegistro.setEstado(0);
			this.userRegistro.setFoto("perfil.png");
			this.userRegistro.setSituacionSentimental("Soltero");
			String cipher = convertirSHA256(this.userRegistro.getClave());
			this.userRegistro.setClave(cipher);
			this.em.persist(this.userRegistro);
			System.out.println("\n r:"+cipher);
			this.em.getTransaction().commit();
			
			this.userRegistro = new Usuario();
			System.out.println("\n USUARIO REGISTRADO");
			return true;

		} catch (Exception e) {
			System.out.println(e);
		}

		return false;

	}

	/**
	 * 
	 * 
	 * Metodo utilizado para iniciar sesion, en base a la clave y el correo suministrado desde 
	 * el formulario de inicio, cifra la clave para comparar los hash en la base de datos
	 * 
	 */
	public boolean inicio() {

		try {
			
			String jpql = " SELECT datos FROM Usuario datos WHERE datos.correo = :correo"
					+ " AND  datos.clave = :clave ";
			
			Query query = this.em.createQuery(jpql);
			
			query.setParameter("correo", this.correo);
			String cipher = convertirSHA256(this.clave);
			query.setParameter("clave",cipher );
			System.out.println("\n i:"+cipher);

			this.user = (Usuario) query.getSingleResult();
			
			System.out.println("INICIO DE SESSION DE: " + this.correo);
			consultarPublicaciones();
			
			return true;
			
		} catch (Exception e) {
			System.out.println("\n  ERROR!");
			System.out.println(e.toString());
			this.user = null;
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario o Contraseña incorrecta", ""));

		}
		
		
		
		return false;

	}

	
	/**
	 * 
	 * Metodo para cerrar sesion, se limpia el usuario utilizado en la sesion 
	 * y se inicializan variables!
	 */
	public boolean salir() {
		try {
			
			this.user = new Usuario();
			this.userRegistro = new Usuario();
			this.correo = "";
			this.clave = "";
			System.out.println("\n SESION CERRADA!");
			return true;

		} catch (Exception e) {
			System.out.println("\n ERROR: " + e.toString());
			return false;

		}
	}

	public List<Administrador> consultarAdministradores() {
		String jpql = " SELECT datos FROM Administrador datos ";
		Query query = this.em.createQuery(jpql);
		List<Administrador> personas = query.getResultList();
		return personas;
	}

	
	/**
	 * 
	 * Metodo utilizado para actualizar los datos del perfil del usuario
	 * en base  un formulario ubicado en configuracion
	 * 
	 * 
	 */
	public int actualizar() {

	
		try {
			this.em.getTransaction().begin();
			if(this.pais.isEmpty() & this.ciudad.isEmpty()){
	
			this.em.merge(this.user);
			}else{
				this.user.setPais(this.pais);
				this.user.setCiudad(this.ciudad);
				this.em.merge(this.user);

			}
			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();
			System.out.println("\n DATOS ACTUALIZADOS CORRECTAMENTE");
			return 1;

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;

	}
	
	
	/**
	 * 
	 * Metodo para elimiar un usuario de la base de datos
	 * va por todos los registro del usuario
	 * si tiene amigos, chats, solicitudes, las elimina 
	 * y luego elimina al usuario
	 */

	public boolean eliminar() {
		if (this.user != null) {
			try {
				
				System.out.println("id: "+this.user.getIdUsuario());
				consultarPublicaciones();
				this.em.getTransaction().begin();

				
				String jpql2 = " SELECT a FROM Amigo a WHERE a.usuario1.idUsuario = :id"
						+ " OR a.usuario2.idUsuario = :id ";
				
				Query query2 = this.em.createQuery(jpql2);
				query2.setParameter("id",this.user.getIdUsuario());
				List<Amigo> amigos =   query2.getResultList();
				for(int k=0;k<amigos.size();k++){
					this.em.remove(amigos.get(k));
				}
				
				String jpql3 = "SELECT s FROM Solicitud s WHERE "
						+ "s.usuario1.idUsuario = :id"
						+ " OR s.usuario2.idUsuario = :d";
				
				Query query3 = this.em.createQuery(jpql3);

				List<Solicitud> solicitudes = query3.getResultList();
				
				
				for(int i=0;i<misPublicaciones.size();i++){

					String jpql = " SELECT c FROM Comentario c WHERE c.publicacion.idPublicacion = :id ";
							
					Query query = this.em.createQuery(jpql);
					query.setParameter("id", misPublicaciones.get(i).getIdPublicacion());
					comentarios =   query.getResultList();
					
					for(int j=0;j<comentarios.size();j++){
					this.em.remove(comentarios.get(j));
				
					}
					
			
					
					this.em.remove(misPublicaciones.get(i));
			

				}
				comentarios=null;
				amigos=null;
				this.em.getTransaction().commit();
				
				String jpql = " SELECT c FROM Comentario c WHERE c.usuario.idUsuario = :id ";
						

				Query query = this.em.createQuery(jpql);
				
				query.setParameter("id", this.user.getIdUsuario());

				comentarios = query.getResultList();
				this.em.getTransaction().begin();

				for(int i=0;i<comentarios.size();i++){
					this.em.remove(comentarios.get(i));
				}
				this.em.getTransaction().commit();

				this.em = this.emf.createEntityManager();

				this.em.getTransaction().begin();
				this.em.merge(this.user);
			
		
				this.em.remove(this.user);
				this.em.getTransaction().commit();
			
				System.out.println("Usuario Elimnado");
			
				this.user = new Usuario();
				this.userRegistro = new Usuario();
				this.correo = "";
				this.clave = "";

				
				return true;
				
				
			} catch (Exception e) {
				System.out.print("ERROR: ");
				System.out.println(e);
				return false;
			}
		}

		return true;
	}

	
	
	/**
	 * 
	 * Metodo que en base a la variable String busqueda
	 * realiza una busqueda en la base de datos, si tiene alguna coincidencia
	 * llena una lista con los resultados
	 * 
	 * 
	 */
	public boolean buscar() {

		if (this.busqueda != null) {

			try {

				String jpql = " SELECT datos FROM Usuario datos WHERE datos.correo LIKE :busqueda"
						+ " OR datos.ciudad LIKE :busqueda"
						+ " OR datos.pais  LIKE :busqueda" 
						+ " OR datos.situacionSentimental LIKE :busqueda ";
				
				
				Query query = this.em.createQuery(jpql);
				query.setParameter("busqueda", "%" + this.busqueda + "%");
				
				resultado = query.getResultList();

				this.busqueda = null;
					
				System.out.println("Buscando...");
				
				return true;

			} catch (Exception e) {
				System.out.println("Error: " + e.toString());
				return false;
			}
		}
		return false;

	}

/**
 * 
 * 
 * Metodo para realizar una publicacion mediante un formulario
 * se obtiene la publicacion (String) y se guarda en la bd 
 * con el usuario que publico
 */
	
	public boolean publicar(){
		System.out.println("Publicando...");

		if(this.publicacion!=null){
		Publicacion nueva = new Publicacion();
		
		try {
			if(this.user==null){
				System.out.println("Usuario vacio");
			}
			nueva.setUsuario(this.user);
	
			Calendar calendario = new GregorianCalendar();
			java.util.Date f = calendario.getTime();
			nueva.setFecha(f);
			nueva.setPublicacion(this.publicacion);
			nueva.setFoto("perfil.png");
			this.em.getTransaction().begin();

			this.em.persist(nueva);

			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();

			nueva=new Publicacion();
			
			System.out.println("\n PUBLICACION REALIZADA");
		
			this.publicacion=null;
			
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ey!", "Publicacion realizada Exitosamente!"));

	        consultarPublicaciones();
	        
			return true;

		} catch (Exception e) {
			System.out.println("error: "+e);
			return false;
		}

		
		}
		return false;
	}
	
	
	
	/**
	 * 
	 * Metodo que busca en la base de datos las publicaciones realizadas por el usuario que 
	 * esta en sesion, llena una lista(misPublicaciones) con las publicaciones
	 */
	public void consultarPublicaciones(){
		try{
			System.out.println("Consultando...");

			if(this.user!=null){
		String jpql = " SELECT p FROM Publicacion p WHERE"
					+ " p.usuario.idUsuario = :id "
					+ " ORDER BY p.idPublicacion DESC";

		Query query = this.em.createQuery(jpql);
		
		query.setParameter("id", this.user.getIdUsuario());

		misPublicaciones = query.getResultList();
			}
		}catch(Exception e){
			System.out.println("Error: "+e.toString());
		}
		
	}

	
	
/**
 * 
 * Metodo utilizado para confirmar si un usuario se puede visitar su perfil
 * se consulta si ese usuario(userAmigo) es amigo o no de el usuario que inicio sesion(user)
 * en caso de que sean amigos retorna 1 en caso contrario retorna 0
 * si son amigos, realiza una consulta a la base de datos para consultar las publicaciones de ese
 * usuario y llena una lista con estas (publicacionesAmigo)
 */
	
	public int sepuedeVisitar(){
		if (this.userAmigo!=null){
			System.out.println("Usuario# "+this.userAmigo.getIdUsuario()+" se puede visitar");
			String jpql = " SELECT a FROM Amigo a WHERE a.usuario1.idUsuario = :id "
					+ "AND a.usuario2.idUsuario = :idU OR a.usuario1.idUsuario = :idU "
					+ "AND a.usuario2.idUsuario = :id ";

			Query query = this.em.createQuery(jpql);
			
			query.setParameter("id", this.user.getIdUsuario());
			query.setParameter("idU", this.userAmigo.getIdUsuario());
			
			List<Amigo> r= query.getResultList();
			if(r.isEmpty()){
			return 0;
			}else{
				
				String jpql2 = " SELECT p FROM Publicacion p WHERE p.usuario.idUsuario = :id";
				Query query2 = this.em.createQuery(jpql2);

				query2.setParameter("id", this.userAmigo.getIdUsuario());
				publicacionesAmigo = query2.getResultList();
				
				return 1;
			}
		}
		System.out.println("No se puede visitar");
		return 2;
	}

	
	/**
	 * 
	 * Metodo utilizado para editar una publicacion, en base a un formulario
	 * un usuario solo puede editar sus propias publicaciones!
	 */
	
	public boolean editarPublicacion(){
		try {
			this.em.getTransaction().begin();
			this.em.merge(this.p);

			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ey!", "Publicacion Actualizada Exitosamente!"));

			System.out.println("\n PUBLICACION ACTUALIZADA CORRECTAMENTE");
			this.p=null;
			
			consultarPublicaciones();
			return true;

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return true;
	}


	/**
	 * 
	 * Metodo utilizado para que un usuario realize un comentario a
	 * una publicacion suya o  de un amigo
	 * 
	 */
	public void comentar(){
		
		
	try{
		if(this.comentario.isEmpty()){
			System.out.println("Comentario vacio");
		}
		System.out.println("Comentario: "+this.comentario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ey!","Comentario Agregado Exitosamente!"));
        Comentario nuevo = new Comentario();
       
		nuevo.setComentario(this.comentario);
		nuevo.setUsuario(this.user);
		Calendar calendario = new GregorianCalendar();
		java.util.Date f = calendario.getTime();
		nuevo.setFecha(f);
		nuevo.setPublicacion(this.p);
	
		
		this.em.getTransaction().begin();

		this.em.persist(nuevo);

		this.em.getTransaction().commit();

	
		nuevo=new Comentario();
	
		consultarComentarios();
		
		System.out.println("\n COMENTARIO REALIZADO");
		this.comentario="";
	}catch(Exception e){
		System.out.println("Error: "+e.toString());
	}
		

	}
	
	
	/**
	 * 
	 * Metodo utilizado para consultar los comentarios de una publicacion
	 * llena un arraylist con los comentarios
	 * 
	 */
	public void consultarComentarios(){
	
		String jpql = " SELECT p FROM Comentario p WHERE "
					+ " p.publicacion.idPublicacion = :id  "
					+ " ORDER BY p.idComentario DESC";

		Query query = this.em.createQuery(jpql);
		
		query.setParameter("id", this.p.getIdPublicacion());

		setComentarios(query.getResultList());
			

	}
	
	
	/**
	 * 
	 * Metodo utilizado para eliminar una publicacion, un usuario solo puede eliminar sus propias
	 * publicaciones
	 */
	public void eliminarPublicacion(){
		
		try{
			

			System.out.println("id: "+this.p.getIdPublicacion());
			consultarComentarios();

			this.em.getTransaction().begin();

			for(int i=0;i<comentarios.size();i++){

				this.em.remove(comentarios.get(i));

				}		
			this.em.getTransaction().commit();

			this.em.getTransaction().begin();
		
			this.em.merge(this.p);

			this.em.remove(this.p);
			this.em.getTransaction().commit();
			System.out.println("Publicacion eliminada");
			consultarPublicaciones();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ey!","Publicacion Eliminada!"));

		}catch(Exception e){
			System.out.println("Error: "+e.toString());
		}
		
	}
	
/**
 * 
 * Metodo utilizado para que un usuario(this.user), envie un mensaje a otro usuario(this.userAmigo)
 * se crea un chat entre los dos en caso de que no exista y se guarda el mensaje correspondiente a ese chat
 */
	public boolean enviarMensaje(){
		 try{
			 
			 Chat chat = new Chat();
			 chat.setUsuario1(this.user);
			 chat.setUsuario2(this.userAmigo);
			 
				Mensaje mensaje = new Mensaje();
			 
			 String jpql = " SELECT c FROM Chat c WHERE"
			 		+ "	c.usuario1.idUsuario = :id"
			 		+ " AND c.usuario2.idUsuario = :idU "
			 		+ " OR"
			 		+ " c.usuario1.idUsuario = :idU "
			 		+ " AND c.usuario2.idUsuario = :id";

				Query query = this.em.createQuery(jpql);
				
				query.setParameter("id", this.user.getIdUsuario());
				query.setParameter("idU", this.userAmigo.getIdUsuario());
				this.em = this.emf.createEntityManager();

				List<Chat> resultado = query.getResultList();
					if (resultado.isEmpty()){
						 
						 
						
						 this.em.getTransaction().begin();
						this.em.persist(chat);
						this.em.getTransaction().commit();
						System.out.println("Chat creado!");

						
					}else{
						
						chat = resultado.get(0);
					}
					
					 
					
					mensaje.setChat(chat);
					Calendar calendario = new GregorianCalendar();
					java.util.Date f = calendario.getTime();
					mensaje.setFecha(f);
					
	
					
					
					String [] mensajeB = TextoABinario(this.msj);

				System.out.println("-------------------------------------------------------");
				System.out.println("\t\t* Cifrando *");
				System.out.println("-------------------------------------------------------");
				
				//Se manda a cifrar
				String [] claveB = TextoABinario(kk);

				String [] cipher = Cifrado_Descifrado_XOR(mensajeB,claveB);
				String mensajeCifrado = BinarioATexto(cipher);
				mensaje.setMensaje(mensajeCifrado);
					mensaje.setEnvia(this.user.getNombre());

					this.em.getTransaction().begin();
					this.em.persist(mensaje);
					this.em.getTransaction().commit();
			     
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ey!","Mensaje Enviado!"));

					System.out.println("Mensaje enviado");
			 this.msj="";
			 
			 return true;
		 }catch(Exception e){
			 System.out.println("Error: "+e.toString());
			 return false;
		 }
		
	}

	
	/**
	 * 
	 * Metodo utilizado para que un usuario(this.user) envie una solicitud de amistad a otro
	 * (this.userAmigo)
	 */
	public boolean enviarSolicitud(){
	
		try{

			Calendar calendario = new GregorianCalendar();
			java.util.Date f = calendario.getTime();
			
			Solicitud solicitud = new Solicitud();
			solicitud.setFecha(f);
			solicitud.setUsuario1(this.user);
			solicitud.setUsuario2(this.userAmigo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ey!","Solicitud Enviada!"));

			this.em = this.emf.createEntityManager();

			this.em.getTransaction().begin();
			this.em.persist(solicitud);
			this.em.getTransaction().commit();
	     

			System.out.println("Solicitud enviada");

			return true;
			
		}catch(Exception e){
			System.out.println("Error: "+e.toString());
		return false;
		}
	}
	
	/**
	 * 
	 * Metodo utilizado para consultar las solicitudes que le llegan a un usuario(this.user)
	 * y retorna una lista con las solicitudes
	 * @return misSolicitudes
	 */
	public List<Solicitud> consultarSolicitudes(){
		
		
		try{
			
			 String jpql = " SELECT s FROM Solicitud s WHERE"
				 		+ " s.usuario2.idUsuario = :id";

					Query query = this.em.createQuery(jpql);
					
					query.setParameter("id", this.user.getIdUsuario());
					
					misSolicitudes = query.getResultList();
					
					System.out.println("Consultando Solicitudes: "+misSolicitudes.size());
			
					return misSolicitudes;
		}catch(Exception e){
			System.out.println("Error: "+e.toString());
		}
		return misSolicitudes;

		
	}
	
	/**
	 * Metodo utilizado para aceptar una solicitud de amistad
	 * se elimina el registro de solicitud en la base de datos
	 * y se crea un registro de amigos entre el usuario que envia y el usuario
	 * que recibe
	 * 
	 */
	public void aceptarSolicitud(){
		
		
		try{
			
			Amigo amigo = new Amigo();
			
			Calendar calendario = new GregorianCalendar();
			java.util.Date f = calendario.getTime();
			
			amigo.setFecha(f);
			
			amigo.setUsuario1(this.solicitud.getUsuario1());
			amigo.setUsuario2(this.user);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ey!","Solicitud Aceptada!"));
			this.em = this.emf.createEntityManager();

			this.em.getTransaction().begin();
			this.em.persist(amigo);
			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();
			this.em.getTransaction().begin();

			if (!em.contains(this.solicitud)) {
			    this.solicitud = em.merge(this.solicitud);
			}

			this.em.remove(this.solicitud);
			this.em.getTransaction().commit();

			System.out.println("Amigo aceptado!");
			
		}catch(Exception e){
			System.out.println("Error: "+e.toString());
		}
	
	}

	
/**
 * Metodo utilizado para cancelar la solicitud de amistad
 * se elimina el registro de la solicitud de la base de datos
 */
	public void cancelarSolicitud(){
		
		try{
			
			this.em = this.emf.createEntityManager();

			this.em.getTransaction().begin();
			if (!em.contains(this.solicitud)) {
			    this.solicitud = em.merge(this.solicitud);
			}
			this.em.remove(this.solicitud);
			this.em.getTransaction().commit();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ey!","Solicitud Cancelada!"));

			System.out.println("Solicitud cancelada!");
			
			
		}catch(Exception e){
			System.out.println("Error: "+e.toString());
		}
	}


	/**
	 * 
	 * Metodo utilizado para consultar los Chats de un usuario,
	 * devuelve una lista con los chats
	 * @return List<Chat>
	 */
	public List<Chat> consultarChat(){
		
		try{
			
			 String jpql = " SELECT c FROM Chat c WHERE"
				 		+ " c.usuario2.idUsuario = :id "
				 		+ " OR"
				 		+ " c.usuario1.idUsuario = :id";

					Query query = this.em.createQuery(jpql);
					
					query.setParameter("id", this.user.getIdUsuario());
					
					chats = query.getResultList();
					
					System.out.println("Consultando Chats: "+chats.size());
			return chats;
		}catch(Exception e){
			System.out.println("Error: "+e.toString());
		}
		return chats;
	}
	
	
	/**
	 * 
	 * Metodo utilizado para confirmar si se puede abrir el chat
	 * si se puede abir, consulta todos los mensajes del chat y los manda a descifrar
	 * @return false o true
	 */
	public boolean irChat(){
		if(this.chat!=null){
			System.out.println("Chat id: "+this.chat.getIdChat());
			 String jpql = " SELECT m FROM Mensaje m WHERE"
				 		+ " m.chat.idChat = :id "
				 		+ " ORDER BY m.idMensaje ASC";

					Query query = this.em.createQuery(jpql);
					
					query.setParameter("id", this.chat.getIdChat());
					mensajes = query.getResultList();

			DescifrarMensajes();
					
			return true;

		}
		return false;
	}
	
	/**
	 * Metodo utilizado para Descifrar los mensajes de un Chat
	 */
	public void DescifrarMensajes(){
		if(this.chat!=null){
			System.out.println("Descifrando mensajes...");
			
				for(int i=0;i<mensajes.size();i++){
					String m = mensajes.get(i).getMensaje();
					String [] me = TextoABinario(m);
					String [] claveB = TextoABinario(kk);
					String[] rr = Cifrado_Descifrado_XOR(me,claveB);
					String mensajeDescifrado = BinarioATexto(rr);
					mensajes.get(i).setMensaje(mensajeDescifrado);
				}
		
		}else{
			System.out.println("Chat Nulo!");
		}
	}
	
	/**
	 * 
	 * Metodo para enviar un mensaje desde el chat
	 * 
	 */
	public void enviarMensajeChat(){
		try{
			
			if(this.chat==null){
				System.out.println("Chat nulo");
			}else{
				
				Mensaje mj = new Mensaje();
				mj.setChat(this.chat);
				Calendar calendario = new GregorianCalendar();
				java.util.Date f = calendario.getTime();
				mj.setFecha(f);
				String [] me = TextoABinario(this.msj);
				String [] claveB = TextoABinario(kk);
				String[] rr = Cifrado_Descifrado_XOR(me,claveB);
				String mensajeCifrado = BinarioATexto(rr);
				
				mj.setMensaje(mensajeCifrado);

				mj.setEnvia(this.user.getNombre());
				this.em = this.emf.createEntityManager();

				this.em.getTransaction().begin();
				
				this.em.persist(mj);
				
				this.em.getTransaction().commit();
				System.out.println("Mensaje Enviado");
				this.msj="";
				irChat();
			}
			
		}catch(Exception e){
			System.out.println("Error: "+e.toString());
		}
		
		
	}
	
	
	/**
	 * Funcion utilizada para generar un Hash256 desde una clave que se pasa como parametro
	 * @param password(String) la clave
	 * return cipher(la clave con la funcion de hash aplicada)
	 */
	public String convertirSHA256(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} 
		catch (NoSuchAlgorithmException e) {		
			e.printStackTrace();
			return null;
		}
		    
		byte[] hash = md.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();
		    
		for(byte b : hash) {        
			sb.append(String.format("%02x", b));
		}
		    
		return sb.toString();
	}

	
	/**
	 * Metodo utilizado para consultar las publicaciones de inicio 
	 * Consulta las publicaciones de sus amigos y las agrega a una lista
	 * @return List<Publicacion> (Lista con las publicaciones)
	 */
	public List<Publicacion> consultarInicio(){
		
		try{
			publicacionesInicio.clear();
			String jpql2 ="SELECT a FROM Amigo a WHERE "
					+ " a.usuario1.idUsuario = :id  OR"
					+ " a.usuario2.idUsuario = :id ";
			
			
			Query query2 = this.em.createQuery(jpql2);
			query2.setParameter("id", this.user.getIdUsuario());
			
			
			List<Amigo> resultado = query2.getResultList();
			System.out.println("Amigos: "+resultado.size());
			LinkedHashSet<Integer> ids = new LinkedHashSet<>();
			for(int i=0;i<resultado.size();i++){
				
				ids.add(resultado.get(i).getUsuario1().getIdUsuario());
				ids.add(resultado.get(i).getUsuario2().getIdUsuario());

			}
			System.out.println("Ids: "+ids.size());
			for(int id : ids){
			
			String jpql ="SELECT p FROM Publicacion p WHERE "
					+ " p.usuario.idUsuario = :id ORDER BY p.idPublicacion DESC";
			Query query = this.em.createQuery(jpql);
			System.out.println("Buscar para id: "+id);
			query.setParameter("id", id);
			publicacionesInicio.addAll( query.getResultList());
			System.out.println("a la verga perro");

			}
		
	
			System.out.println("Publicaciones inicio: "+publicacionesInicio.size());
			
			return publicacionesInicio;
		}catch(Exception e){
			System.out.println("Error: "+e.toString());
		}
		return publicacionesInicio;

	}
	
	/*
	 * 
	 * Metodo que realiza una compuerta XOR sobre dos binarios
	 * retorna el binario resultado
	 */

	
public static String CompuertaXOR (String binario1 , String binario2){
		
		char [] operando1 = binario1.toCharArray();
		char [] operando2 = binario2.toCharArray();
		char [] r =new char [operando1.length];
		
	for(int i=0;i<operando1.length ;i++){
		
		
		if(operando1[i]!=operando2[i]){
				r [i]='1';
			}else {
				r [i]= '0';
			}
	}	

	String re="";
	for(int j=0;j<r.length;j++){
		re+=r[j];
	}

		return re;
	}
	
/**
 *  Metodo utilizado para cifrar y Descifrar mensajes,
 * @param mensaje (binarios del mensaje)
 * @param clave (binarios de la clave)
 * @return binario resultado de la compuerta
 */
public static String [] Cifrado_Descifrado_XOR (String [] mensaje,String [] clave){
	
	String [] resultado = new String [mensaje.length];
	int puntero=0;

	for(int i =0 ;i<mensaje.length;i++){
		
		if(puntero>=clave.length){
			puntero =0;
		}
		resultado[i]= CompuertaXOR(mensaje[i],clave[puntero]);
		
		puntero++;
	}
	
	return resultado;
}

/**
 * Metodo utilizado para convertir un texto a binario
 * @param texto (a convertr en binarios) 
 * @return un Array con los binarios del Texto
 */
public static String [] TextoABinario(String texto){
	
	char caracter;
	int codigoASCII;
	String binario;
	String [] binarios = new String [texto.length()];
	
	for (int i=0;i<texto.length();i++){
		
		caracter = texto.charAt(i);
		codigoASCII = (int) caracter;
		
		binario = "";
		
		
		for(int j=7;j>=0;j--){
			if(codigoASCII>=Math.pow(2, j)){
				codigoASCII-=Math.pow(2,j);
				binario +="1";
			}else{
				binario+="0";
			}
		}
	
		binarios[i]= binario.toString();

		
	}
	return binarios;
}
/**
 * Metodo utilizado para convertir un binario a texto
 * @param binario (a convertr en texto) 
 * return un String de el texto convertido
 */

public static String BinarioATexto(String [] binarios){
	String texto="";
	
	for(int j=0;j<binarios.length;j++){
	char [] bin = binarios[j].toCharArray();
	
	int decimal =0;
	
	int contador=0;
	for(int i=bin.length-1;i>-1;i--){

		if(bin[contador]=='1'){
			decimal+=Math.pow(2, i);
		}
		
		contador++;
	}
	
	texto+= (char) decimal;
	
	}
	
	return texto;
}

}
