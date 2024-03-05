/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Config.GenerarSerie;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DIDIER
 */
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Cliente c = new Cliente();
    ClienteDAO cDAO = new ClienteDAO();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    VentaDAO vdao = new VentaDAO();
    int ide;
    int idc;
    int idp;
    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;

    String numeroserie;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession valsession = request.getSession();
        if (valsession.getAttribute("ususession") == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            String menu = request.getParameter("menu");
            String accion = request.getParameter("accion");
            System.out.println("entro a controlador: " + menu + " - " + accion);
            if (menu.equals("Principal")) {
                System.out.println("llama a principal.jsp");
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }
            System.out.println("etro a controlador:" + menu + " - " + accion);
            if (menu.equals("Principal")) {
                System.out.println("llama a principal.jsp");
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }
//EMPLEADO
            if (menu.equals("Empleado")) {
                System.out.println("entro a if empleado");
                switch (accion) {
                    case "Listar":
                        System.out.println("entro al menu listar empleado");
                        List lista = edao.Listar();
                        request.setAttribute("empleados", lista);
                        request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                        break;
                    case "Agregar":
                        String dni = request.getParameter("txtDni");
                        String nom = request.getParameter("txtNombres");
                        String tel = request.getParameter("txtTelefono");
                        String est = request.getParameter("txtEstado");
                        String user = request.getParameter("txtUsuario");
                        em.setDni(dni);
                        em.setNom(nom);
                        em.setTel(tel);
                        em.setEstado(est);
                        em.setUser(user);
                        edao.agregar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));
                        Empleado e = edao.ListarId(ide);
                        request.setAttribute("empleado", e);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String dni1 = request.getParameter("txtDni");
                        String nom1 = request.getParameter("txtNombres");
                        String tel1 = request.getParameter("txtTelefono");
                        String est1 = request.getParameter("txtEstado");
                        String user1 = request.getParameter("txtUsuario");
                        em.setDni(dni1);
                        em.setNom(nom1);
                        em.setTel(tel1);
                        em.setEstado(est1);
                        em.setUser(user1);
                        em.setId(ide);
                        edao.actualizar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        ide = Integer.parseInt(request.getParameter("id"));
                        edao.delete(ide);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }

                request.getRequestDispatcher("Empleado.jsp").forward(request, response);

            }
//CLIENTE
            if (menu.equals("Cliente")) {
                switch (accion) {
                    case "Listar":
                        System.out.println("entro al menu listar CLIENTE");
                        List lista = cDAO.Listar();
                        request.setAttribute("clientes", lista);
                        request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                        break;
                    case "Agregar":
                        String dni = request.getParameter("txtDni");
                        String nom = request.getParameter("txtNombres");
                        String dir = request.getParameter("txtDireccion");
                        String est = request.getParameter("txtEstado");
                        c.setDni(dni);
                        c.setNom(nom);
                        c.setDir(dir);
                        c.setEst(est);
                        cDAO.agregar(c);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        idc = Integer.parseInt(request.getParameter("id"));
                        Cliente c = cDAO.ListarId(idc);
                        request.setAttribute("cliente", c);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String dni1 = request.getParameter("txtDni");
                        String nom1 = request.getParameter("txtNombres");
                        String dir1 = request.getParameter("txtDireccion");
                        String est1 = request.getParameter("txtEstado");
                        this.c.setDni(dni1);
                        this.c.setNom(nom1);
                        this.c.setDir(dir1);
                        this.c.setEst(est1);
                        this.c.setId(idc);
                        cDAO.actualizar(this.c);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        idc = Integer.parseInt(request.getParameter("id"));
                        cDAO.delete(idc);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }

            }
//PRODUCTO
            if (menu.equals("Producto")) {
                switch (accion) {
                    case "Listar":
                        List lista = pdao.listar();
                        request.setAttribute("productos", lista);
                        request.getRequestDispatcher("Producto.jsp").forward(request, response);
                        break;
                    case "Agregar":
                        String nom = request.getParameter("txtNombres");
                        String pre = request.getParameter("txtPrecio");
                        int stock = Integer.parseInt(request.getParameter("txtStock"));
                        String est = request.getParameter("txtEstado");
                        p.setNom(nom);
                        p.setPre(pre);
                        p.setStock(stock);
                        p.setEstado(est);
                        pdao.agregar(p);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        idp = Integer.parseInt(request.getParameter("id"));
                        Producto p = pdao.ListarId(idp);
                        request.setAttribute("producto", p);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String nom1 = request.getParameter("txtNombres");
                        String pre1 = request.getParameter("txtPrecio");
                        int stock1 = Integer.parseInt(request.getParameter("txtStock"));
                        String est1 = request.getParameter("txtEstado");
                        this.p.setNom(nom1);
                        this.p.setPre(pre1);
                        this.p.setStock(stock1);
                        this.p.setEstado(est1);
                        this.p.setId(idp);
                        pdao.actualizar(this.p);

                        cDAO.actualizar(this.c);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        idc = Integer.parseInt(request.getParameter("id"));
                        pdao.delete(idp);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
            }
//NUEVA VENTA
            if (menu.equals("NuevaVenta")) {
                switch (accion) {
                    case "BuscarCliente":
                        String dni = request.getParameter("CodigoCliente");
                        c.setDni(dni);
                        cDAO.buscar(dni);
                        c = cDAO.buscar(dni);
                        request.setAttribute("c", c);
                        break;
                    case "BuscarProducto":
                        int id = Integer.parseInt(request.getParameter("CodigoProducto"));
                        p = pdao.ListarId(id);
                        request.setAttribute("c", c);
                        request.setAttribute("producto", p);
                        request.setAttribute("Lista", lista);
                        break;
                    case "Agregar":
                        System.out.println("entro a agregar venta");
                        totalPagar = 0.0;
                        item = item + 1;
                        p = (Producto) request.getAttribute("producto");
                        if (p.getId() != null) {
                            cod = p.getId();
                        } else {
                            System.out.println("es nulo el id");
                        }

//                        descripcion = request.getParameter("nomproducto");
                        descripcion = p.getNom();
//                        precio = Double.parseDouble(request.getParameter("Precio"));
                        precio = Double.parseDouble(p.getPre());
                        cant = Integer.parseInt(request.getParameter("cant"));
                        subtotal = precio * cant;
                        v = new Venta();
                        v.setItem(item);
                        v.setIdproducto(cod);
                        v.setDescripcionP(descripcion);
                        v.setPrecio(precio);
                        v.setCantidad(cant);
                        v.setSubtotal(subtotal);
                        lista.add(v);
                        for (int i = 0; i < lista.size(); i++) {
                            totalPagar = totalPagar + lista.get(i).getSubtotal();
                            System.out.println("entro al for de listar venta: ");
                        }
                        request.setAttribute("c", c);
                        request.setAttribute("Producto", p);
                        request.setAttribute("totalPagar", totalPagar);
                        request.setAttribute("Lista", lista);
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                        break;

                    case "GenerarVenta":
                        for (int i = 0; i < lista.size(); i++) {
                            Producto pr = new Producto();
                            int cantidad = lista.get(i).getCantidad();
                            int idproducto = lista.get(i).getIdproducto();
                            ProductoDAO aO = new ProductoDAO();
                            pr = aO.buscar(idproducto);
                            int sac = pr.getStock() - cantidad;
                            aO.actualizarstock(idproducto, sac);
                        }
                        v.setIdcliente(c.getId());
                        v.setIdempleado(2);
                        v.setNumserie(numeroserie);
                        v.setFecha("2020-06-14");
                        v.setMonto(totalPagar);
                        v.setEstado("1");
                        vdao.guardarVenta(v);
                        int idv = Integer.parseInt(vdao.IdVentas());
                        for (int i = 0; i < lista.size(); i++) {
                            v = new Venta();
                            v.setId(idv);
                            v.setIdproducto(lista.get(i).getIdproducto());
                            v.setCantidad(lista.get(i).getCantidad());
                            v.setPrecio(lista.get(i).getPrecio());
                            vdao.guardarDetalleVentas(v);
                        }

                        break;

                    default:
                        numeroserie = vdao.GenerarSerie();
                        if (numeroserie == null) {
                            numeroserie = "00000001";
                            request.setAttribute("nserie", numeroserie);
                        } else {
                            int incrementar = Integer.parseInt(numeroserie);
                            GenerarSerie gs = new GenerarSerie();
                            numeroserie = gs.NumeroSerie(incrementar);
                            request.setAttribute("nserie", numeroserie);

                        }
                        break;

                }
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            response.setContentType(
                    "text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Controlador</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
