using Microsoft.AspNetCore.Mvc;
using System.Data;

namespace Q2.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            DataProvider data = new DataProvider();
            IDataReader dr = data.executeQuery2("SELECT [ProductID]\r\n      ,[ProductName]\r\n  FROM [dbo].[Products]");
            DataTable dt = new DataTable();
            dt.Columns.AddRange(new DataColumn[2] { new DataColumn("ProductID"), new DataColumn("ProductName")});
            
            List<int> list = new List<int>();

            while (dr.Read())
            {
                dt.Rows.Add(dr.GetInt32(0), dr.GetString(1));
                list.Add(dr.GetInt32(0));
            }
            dr.Close();
            
            ViewBag.ListP = list;
            return View();
        }

    }
}
