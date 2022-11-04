using Microsoft.AspNetCore.Mvc;

namespace Q2.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }

    }
}
