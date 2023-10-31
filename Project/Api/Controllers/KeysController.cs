using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Api.Models;
using Microsoft.AspNetCore.OData.Query;

namespace Api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class KeysController : ControllerBase
    {
        private readonly MyStoreContext _context;

        public KeysController(MyStoreContext context)
        {
            _context = context;
        }

        // GET: api/Keys
        [HttpGet]
        [EnableQuery]

        public async Task<ActionResult<IEnumerable<Key>>> GetKeys()
        {
          if (_context.Keys == null)
          {
              return NotFound();
          }
            return await _context.Keys.ToListAsync();
        }


        [HttpGet("key")]
        [EnableQuery]
        public async Task<ActionResult<bool>> GetKey(string key)
        {
            return await _context.Keys.AnyAsync(c => c.KeyId == key);
        }

        private bool KeyExists(string id)
        {
            return (_context.Keys?.Any(e => e.KeyId == id)).GetValueOrDefault();
        }
    }
}
